package Interface;

import Entidades.Venda;
import Exceptions.SaidaException;

public interface ValidaNFE {

     Venda validarCliente(Venda venda) throws SaidaException;

}
