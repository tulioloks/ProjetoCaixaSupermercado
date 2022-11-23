package Enums;

public enum TipoPessoa {

    FISICA, JURIDICA;

    public static TipoPessoa getTipobyId(int id) {
        if(id == 0) {
            return FISICA;
        }

        else {
            return JURIDICA;
        }
    }
}
