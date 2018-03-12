/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedados;

/**
 *
 * @author SyD
 */
public class Fatura {
    int ID ;
    String Descricao;
    String Quantidade;
    
    public Fatura (int ID, String Descricao, String Quantidade){
        this.ID =ID;
        this.Descricao=Descricao;
        this.Quantidade=Quantidade;
    }
    public int getID(){
        return ID;
    }
    public String getDescricao(){
        return Descricao;
    }
    public String getQuantidade(){
        return Quantidade;
    }
    public String toString(){
        return "ID ["+ID+"] Descricao["+Descricao+"] Quantidade["+Quantidade+"]";
    }
    public Object[] covToObjectVect(){
    	Object[] str = {ID+"",Descricao,Quantidade};
    	return str;
    }
}
