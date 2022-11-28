package FormatosDocumento;

import java.util.ArrayList;
import java.util.List;

public class FormatoCnpj {

    public static Boolean verificarFormato(String cnpj) {
        // verifica se o cnpj esta no formato 12.345.789/0001-10
        // retorna true se o formato estiver correto e false se não estiver

        String caracteresNumericoscnpj="";

        if (cnpj.length() == 18) {//verifica se o cnpj está no tamanho correto

            List<String> caracteresCnpj = new ArrayList<>();

            for(int i = 0; i < 18; i++) {
                caracteresCnpj.add(cnpj.substring(i, i+1));
            }


            if (caracteresCnpj.get(2).equals(".") && caracteresCnpj.get(6).equals(".") //Verifica se o cnpj tem dois ponto, a barra, o traço e o padrão 0001 em seus devidos lugares
                    && caracteresCnpj.get(10).equals("/") && caracteresCnpj.get(15).equals("-") && cnpj.substring(11, 15).equals("0001")) {

                for(int i = 0; i < 18; i++) {
                    if(!caracteresCnpj.get(i).equals(".") && !caracteresCnpj.get(i).equals("/")
                            && !caracteresCnpj.get(i).equals("-") && i < 10 || i > 15) {//Pega os caracteres que deviam ser números no cnpj, tirando o padrão 0001.
                        caracteresNumericoscnpj += caracteresCnpj.get(i);
                    }

                }

            }

        }
        try {

            long numerosCnpj = Long.parseLong(caracteresNumericoscnpj);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }

    }
}
