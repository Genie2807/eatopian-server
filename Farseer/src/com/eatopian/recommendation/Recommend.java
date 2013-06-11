package com.eatopian.recommendation;

import org.bson.types.ObjectId;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Vanilla
 * Date: 13-6-10
 * Time: 上午9:58
 * To change this template use File | Settings | File Templates.
 */
public class Recommend {
    private DAO dao= null;

    private static class UserProfile {
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        private String userName;
        private Set<String> userLiked = new HashSet<String>();

        public void addUserLiked(String liked) {
            this.userLiked.add(liked);
        }

        public Set<String> getUserLiked() {
            return this.userLiked;
        }

        public UserProfile(String fileName) {
            this.readFromFile(fileName);
        }

        public void readFromFile(String fileName) {
            File file = new File(fileName);
            BufferedReader reader = null;
            InputStreamReader read = null;
            try {
                read = new InputStreamReader(new FileInputStream(file),"UTF-8");
                reader = new BufferedReader(read);
                String tempString = null;
                int line = 1;
                while ((tempString = reader.readLine()) != null){
                    tempString=tempString.trim();
                    if(tempString.startsWith("$")) {
                        this.userName=tempString.substring(1);
                    } else {
                        this.addUserLiked(tempString);
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (FileNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
    }

    public Recommend(DAO dao) {
        this.dao=dao;
    }

    public List<Dish> basedOn(UserProfile user) {
        List<String> allRelatedDishes=new ArrayList<String>();
        for(String currentDish:user.getUserLiked()) {
            allRelatedDishes.addAll(this.dao.getDishSimilarity(new ObjectId(currentDish)).keySet());
        }
        System.out.println(allRelatedDishes);
        List<Dish> res=new ArrayList<Dish>();
        while(res.size()<5) {
            double d=Math.random();
            int index=(int)(d*allRelatedDishes.size());
            String currentDish=allRelatedDishes.get(index);
            if(!user.getUserLiked().contains(currentDish)) {
                res.add(this.dao.getDish(new ObjectId(currentDish)));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Recommend recommend=new Recommend(new Mongodb());
        UserProfile user=new UserProfile("sb.txt");
        System.out.println(recommend.basedOn(user));
    }




}
