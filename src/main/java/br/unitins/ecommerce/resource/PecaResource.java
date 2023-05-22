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
import br.unitins.ecommerce.dto.PecaDTO;
import br.unitins.ecommerce.dto.PecaResponseDTO;
import br.unitins.ecommerce.service.PecaService;

@Path("/pecas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PecaResource {
    @Inject
    PecaService pecaService;

    @GET
    public List<PecaResponseDTO> getAll() {
        return pecaService.getAll();
    }

    @GET
    @Path("/{id}")
    public PecaResponseDTO findById(@PathParam("id") Long id) {
        return pecaService.findById(id);
    }

    @POST
    public Response insert(PecaDTO dto) {
        try {
            PecaResponseDTO hardware = pecaService.create(dto);
            return Response.status(Status.CREATED).entity(hardware).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PecaDTO dto) {
        try {
            PecaResponseDTO peca = pecaService.update(id, dto);
            return Response.ok(peca).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        pecaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public long count() {
        return pecaService.count();
    }

    @GET
    @Path("/search/{marca}")
    public List<PecaResponseDTO> search(@PathParam("marca") String marca) {
        return pecaService.findByMarca(marca);
    }
}
