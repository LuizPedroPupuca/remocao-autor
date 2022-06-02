package br.com.zup.edu.autor;

public class RemoveAutorRequest {

    private Long idAutor;

    public RemoveAutorRequest(Long idAutor) {
        this.idAutor = idAutor;
    }

    public RemoveAutorRequest() {
    }

    public Long getIdAutor() {
        return idAutor;
    }
}
