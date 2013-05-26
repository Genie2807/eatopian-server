package com.eatopian.recommendation;

import java.util.*;

/**
 * Created with IntelliJ IDEA. User: Vanilla Date: 13-5-26 Time: 下午2:33 To
 * change this template use File | Settings | File Templates.
 */
public class Similarity {
    private Map<String, Integer> IngredientMap;
    private Map<String, Integer> TasteMap;
    private Map<String, Integer> CookingMap;
    private DAO dao;
    private List<Dish> allDish;

    public static void main(String[] args) {
        (new Similarity()).work();
    }

    public void work() {
        DAO dao=new Mongodb();
        this.init(dao);
        this.getAllSimilarityForAllDishes();
    }

    public void init(DAO dao) {
        this.dao = dao;
        IngredientMap = dao.getIngredientMap();
        TasteMap = dao.getTasteMap();
        CookingMap = dao.getCookingMap();
        allDish = dao.getAllDishes();
    }

    private double[] getRepresentativeVector(List<String> tagList,
                                             Map<String, Integer> map) {
        Integer vSize = map.size();
        double[] rv = new double[vSize];
        for (String tag : tagList) {
            rv[map.get(tag)] = 1.0;
        }
        return rv;
    }

    private double getVectorProduct(List<String> tag1, List<String> tag2,
                                    Map<String, Integer> map) {
        Integer vSize = map.size();
        double[] v1 = this.getRepresentativeVector(tag1, map);
        double[] v2 = this.getRepresentativeVector(tag2, map);
        double res = 0.0;
        double len1 = 0.0;
        double len2 = 0.0;
        for (int i = 0; i < vSize; i++) {
            res += v1[i] * v2[i];
            len1 += v1[i] * v2[i];
            len2 += v1[i] * v2[i];
        }
        res = res / Math.sqrt(len1) / Math.sqrt(len2);
        return res;
    }

    private double getSimilarity(Dish dish1, Dish dish2) {
        double similarityIngredient = 0;
        double similarityTaste = 0;
        double similarityCooking = 0;
        similarityIngredient = this.getVectorProduct(
                dish1.getIngredientTagList(), dish2.getIngredientTagList(),
                this.IngredientMap);
        similarityTaste = this.getVectorProduct(dish1.getTasteTagList(),
                dish2.getTasteTagList(), this.TasteMap);
        similarityCooking = this.getVectorProduct(dish1.getCookingTagList(),
                dish2.getCookingTagList(), this.CookingMap);
        double similarity = similarityTaste * 0.5 + similarityCooking * 0.25
                + similarityIngredient * 0.25;
        return similarity;
    }

    private class PriorityDish {
        private double similarity;

        private String getDishId() {
            return dishId;
        }

        private void setDishId(String dishId) {
            this.dishId = dishId;
        }

        private String dishId;

        public PriorityDish(double similarity, String dishID) {
            this.similarity = 0.0;
            this.dishId = dishId;
        }

        public double getSimilarity() {
            return this.similarity;
        }

        public void setSimilarity(double similarity) {
            this.similarity = similarity;
        }


    }

    private Map<String, Double> getAllSimilarityForDish(Dish dish1) {
        PriorityQueue<PriorityDish> heap = new PriorityQueue<PriorityDish>(20,
                new Comparator<PriorityDish>() {
                    @Override
                    public int compare(PriorityDish o1, PriorityDish o2) {
                        if (o1.similarity > o2.similarity) return -1;
                        if (o1.similarity < o2.similarity) return 1;
                        return 0;
                    }
                });
        for (Dish dish2 : this.allDish) {
            double s = this.getSimilarity(dish1, dish2);
            heap.add(new PriorityDish(s, dish2.getDishID()));
        }
        Map<String, Double> map = new HashMap<String, Double>();
        int sizeH = heap.size();
        for (int i = 0; i < 20 && i < sizeH; i++) {
            PriorityDish pd = heap.poll();
            map.put(pd.getDishId(), pd.getSimilarity());
        }
        return map;
    }

    private void getAllSimilarityForAllDishes() {
        for(Dish dish1:this.allDish) {
            Map<String, Double> map=getAllSimilarityForDish(dish1);
            this.dao.addDishSimilarity(dish1.getDishID(),map);
        }
    }

}
