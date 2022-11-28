package FormatosDocumento;

import java.util.ArrayList;
import java.util.List;

public class FormatoCpf {


    public static Boolean verificarFormato(String cpf) {
        // Verifica se o cpf está no formato 123.456.789-10
        // retorna true se o formato estiver correto e false se não estiver
        String caracteresNumericosCpf = "";

        if (cpf.length() == 14) { //verifica se o cpf está no tamanho correto
            List<String> caracteresCPF = new ArrayList<>();
            for (int i = 0; i < 14; i++) {//Adiciona os caracteres do cpf a lista
                caracteresCPF.add(cpf.substring(i, i+1));
            }


            if (caracteresCPF.get(3).equals(".") && caracteresCPF.get(7).equals(".") && caracteresCPF.get(11).equals("-")) {//verifica se o cpf tem pontos e o traço nos lugares corretos


                for (String caractere: caracteresCPF) {
                    if (!caractere.equals(".") && !caractere.equals("-")) {
                        //Pega todos os caracteres do cpf que deviam ser números.
                        caracteresNumericosCpf += caractere;
                    }
                }


            }


        }

        try {
            //Verificação para ver se os caracteres informados (tirando pontos e o traço) são números.
            long numerosCpf = Long.parseLong(caracteresNumericosCpf);

            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
