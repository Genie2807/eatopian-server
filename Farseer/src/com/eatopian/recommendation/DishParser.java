package com.eatopian.recommendation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vanilla
 * Date: 13-5-26
 * Time: 下午9:22
 * To change this template use File | Settings | File Templates.
 */
public class DishParser {

    public static void main(String[] args) {
        readFileByLines("test.txt");
    }

    public static void readFileByLines(String fileName) {
        DAO dao=new Mongodb();
        File file = new File(fileName);
        BufferedReader reader = null;
        Dish currentDish=new Dish();   //just a dummy.
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                tempString=tempString.trim();
                switch(line) {
                    case 1:
                        if(tempString.startsWith("!")) {
                            currentDish=new Dish();
                            currentDish.setRestaurantName(tempString.substring(1));
                            line=2;
                        }
                        break;
                    case 2:
                        if(tempString.startsWith("!")) {
                            currentDish.setRestaurantChineseName(tempString.substring(1));
                            line=3;
                        }
                        break;
                    case 3:
                        if(tempString.startsWith("@")&&line==3) {
                            currentDish.setDishName(tempString.substring(1));
                            line=4;
                        }
                        break;
                    case 4:
                        if(tempString.startsWith("@")&&line==4) {
                            currentDish.setDishChineseName(tempString.substring(1));
                            line=5;
                        }
                        break;
                    case 5:
                        if(tempString.startsWith("$")&&line==5) {
                            currentDish.setIngredientTagList(new ArrayList<String>(Arrays.asList(tempString.substring(1).split(","))));
                            line=6;
                        }
                        break;
                    case 6:
                        if(tempString.startsWith("$")&&line==6) {
                            currentDish.setTasteTagList(new ArrayList<String>(Arrays.asList(tempString.substring(1).split(","))));
                            line=7;
                        }
                        break;
                    case 7:
                        if(tempString.startsWith("$")&&line==7) {
                            currentDish.setCookingTagList(new ArrayList<String>(Arrays.asList(tempString.substring(1).split(","))));
                            dao.addDish(currentDish);
                            line=1;
                        }
                        break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
