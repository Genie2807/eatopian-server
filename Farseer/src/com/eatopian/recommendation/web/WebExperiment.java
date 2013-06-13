package com.eatopian.recommendation.web;
import com.eatopian.recommendation.DAO;
import com.eatopian.recommendation.Dish;
import com.eatopian.recommendation.Mongodb;
import com.eatopian.recommendation.Recommend;
import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.eatopian.recommendation.Recommend.UserProfile;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: Vanilla
 * Date: 13-6-13
 * Time: 
H3:32
 * To change this template use File | Settings | File Templates.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class WebExperiment {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getFrames() {
        return "<html><head><title>Eatopian Recommendation System alpha-100</title></head>" +
                "<frameset cols=\"33%,34%,33%\">" +
                "  <frame src=\"like\">" +
                "  <frame src=\"about_blank\" name=\"recommend\">" +
                "  <frame src=\"about_blank\" name=\"dishinfo\">" +
                "</frameset>" +
                "</html>";
    }

    @Path("like")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllDishes() {
        // Return some cliched textual content
        DAO dao=new Mongodb();
        List<Dish> all=dao.getAllDishes();
        StringBuilder sb=new StringBuilder("<form target=\"recommend\" action=\"http://localhost:9998/helloworld/commit\" method=\"POST\">");
        for(Dish d:all) {
            sb.append("<input type=\"checkbox\" name=\"param\" value=\"").append(d.getDishID().toString()).append("\">").append(this.getDishLink(d)).append("</input><br />");
        }
        sb.append("<input type=\"submit\" value=\"确定\" /></form>");
        return this.prefixAndSuffix(sb);
    }

    @Path("commit")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String postForm(@FormParam("param") List<String> param) {
        UserProfile user=new UserProfile();
        user.setUserName("Online");
        user.addUserLikedList(param);
        DAO dao=new Mongodb();
        Recommend recommend = new Recommend(dao);
        List<Dish> dishs = recommend.basedOn(user);
        StringBuilder sb=new StringBuilder();
        sb.append("基于<br />");
        for(String id:param) {
            sb.append(this.getDishLink(dao.getDish(new ObjectId(id)))).append("<br />");
        }
        sb.append("作出的推荐：<hr />");

        for(Dish d:dishs) {
            sb.append(this.getDishLink(d)).append("<br />");
        }
        return this.prefixAndSuffix(sb);
    }

    @Path("dish/{id}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getDishInfo(@PathParam("id")String dishId) {
        DAO dao=new Mongodb();
        Dish dish=dao.getDish(new ObjectId(dishId));
        StringBuilder sb=new StringBuilder();
        sb.append(dish.getDishID()).append("<br />");
        sb.append(dish.getRestaurantName()).append("<br />");
        sb.append(dish.getRestaurantChineseName()).append("<br />");
        sb.append(dish.getDishName()).append("<br />");
        sb.append(dish.getDishChineseName()).append("<br />");
        sb.append(dish.getIngredientTagList()).append("<br />");
        sb.append(dish.getTasteTagList()).append("<br />");
        sb.append(dish.getCookingTagList()).append("<br />");
        return this.prefixAndSuffix(sb);
    }

    public String getDishLink(Dish dish) {
        return "<a href=\"dish/"+dish.getDishID()+"\" target=\"dishinfo\">"+ dish.getRestaurantChineseName() + " 的 "+dish.getDishChineseName()+"</a>";
    }

    public String prefixAndSuffix(StringBuilder content) {
        StringBuilder sb=new StringBuilder("<html><head><title>Eatopian Recommendation System alpha-100</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head><body>");
        sb.append(content);
        sb.append("</body></html>");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        server.start();

        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/helloworld");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}