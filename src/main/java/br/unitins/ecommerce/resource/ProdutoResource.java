package br.unitins.ecommerce.resource;


import java.util.List;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import br.unitins.ecommerce.application.Result;
import br.unitins.ecommerce.dto.ProdutoDTO;
import br.unitins.ecommerce.dto.ProdutoResponseDTO;
import br.unitins.ecommerce.service.ProdutoService;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    @Inject
    ProdutoService produtoService;

    @GET
    public List<ProdutoResponseDTO> getAll() {
        return produtoService.getAll();
    }

    @GET
    @Path("/{id}")
    public ProdutoResponseDTO findById(@PathParam("id") Long id) {
        return produtoService.findById(id);
    }

    @POST
    public Response insert(ProdutoDTO dto) {
        try {
            ProdutoResponseDTO produto = produtoService.create(dto);
            return Response.status(Status.CREATED).entity(produto).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ProdutoDTO dto) {
        try {
            ProdutoResponseDTO produto = produtoService.update(id, dto);
            return Response.ok(produto).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        produtoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public long count() {
        return produtoService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<ProdutoResponseDTO> search(@PathParam("nome") String nome) {
        return produtoService.findByNome(nome);
    }
}

