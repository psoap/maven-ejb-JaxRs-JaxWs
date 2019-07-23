package com.epam.newsportal.controller;

import com.epam.newsportal.domain.News;
import com.epam.newsportal.ejb.NewsService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@ApplicationScoped
@Path("")
public class JaxRsController {
    @Inject
    private NewsService newsService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showNewsByPage() {
        return showNewsByPage(0);
    }

    @GET
    @Path("/{pageNumber : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showNewsByPage(@PathParam("pageNumber") final int pageNumber) {
        return Response.ok().entity(newsService.getNewsListByPage(pageNumber)).build();
    }

    @GET
    @Path("/news/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showNewsByUri(@PathParam("id") final long id) {
        return Response.ok().entity(newsService.getNewsById(id)).build();
    }

    @POST
    @Path("/news")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNews(News news) {
        newsService.addNews(news);
        return Response.ok().build();
    }

    @PUT
    @Path("/news/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editNews(News news) {
        newsService.editNews(news);
        return Response.ok().build();
    }

    @DELETE
    @Path("/news/{id}")
    public Response removeNews(@PathParam("id") Long id) {
        newsService.removeNews(Collections.singletonList(id));
        return Response.ok().build();
    }
}