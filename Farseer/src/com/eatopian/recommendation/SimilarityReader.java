package com.eatopian.recommendation;

import org.bson.types.ObjectId;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Vanilla
 * Date: 13-6-8
 * Time: 下午3:39
 * To change this template use File | Settings | File Templates.
 */
public class SimilarityReader {
    public static void main(String[] args) {
        (new SimilarityReader()).work();
    }

    private DAO dao;

    public void work() {
        DAO dao=new Mongodb();
        List<Dish> alldish=dao.getAllDishes();
        try {
            PrintWriter writer=new PrintWriter(new File("similarity.txt"));
            for(Dish dish:alldish) {
                writer.println();
                writer.println(dish.getDishChineseName());
                writer.flush();
                Map<String,Double> map=dao.getDishSimilarity(dish.getDishID());
                for(Map.Entry e:map.entrySet()) {
                    Dish d=dao.getDish(new ObjectId((String)e.getKey()));
                    writer.println(d.getDishChineseName()+"::"+((Double)e.getValue()).toString());
                    writer.flush();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
