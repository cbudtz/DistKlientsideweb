package restServices;

import data.Note;
import data.NoteDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("noter")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoteService {
    private static NoteDao noteDao = new NoteDao();

    @GET
    public List<Note> getNoter(){
        System.out.println("noteService.getNoter() kaldt - der er " + noteDao.getNoter().size() + " noter" );
        return noteDao.getNoter();
    }

    @POST
    public List<Note> postNote(Note note){
        System.out.println("noteService.postNote() kaldt " + note.getTekst() );
        if(note!=null) {
            noteDao.saveNote(note);
        }
        return getNoter();
    }

    @DELETE
    @Path("{id}")
    public List<Note> deleteNote(@PathParam("id") int noteID){
        System.out.println("noteService.deleteNote() kaldt med id " + noteID );
        noteDao.deleteNote(noteID);
        return getNoter();

    }
}
