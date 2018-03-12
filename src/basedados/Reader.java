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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
 
public class Reader {
    private BufferedReader br;
    private String [] Columns;
    private final int numOfColumns=3;

    private List<Fatura> Data = new ArrayList<Fatura>();
    // Parameters Delimiters customization
    private String tParamDelimiterA = ";"; // Parameter delimiter on file - space by default
    private String tDirectory = "data/"; // Data director on project
	protected String[] getColumns;

    public Reader() {
        this.Columns = new String [numOfColumns];
    }
 
    /*PARAM:
    tfileName   - filename
    nLinCommand - line counts with parameters
    nParam      - count of total number of parameters
    tParamName  - name of parameters splited by ";"
     */
    @SuppressWarnings("empty-statement")
    public void readFile(String tfileName) {
        Columns[0]="ID";
        Columns[1]="Descrição";
        Columns[2]="Quantidade";
        
        try {
            // Open file
            br = new BufferedReader(new FileReader(tDirectory + tfileName));
 
            while (br.ready()) {
                //
                String line = br.readLine();
                String [] s = line.split(tParamDelimiterA);
                int id = Integer.parseInt(s[0]);
                String descricao = s[1];
                String quantidade = s[2];
                Fatura fatura = new Fatura(id,descricao,quantidade);
                Data.add(fatura);
//                
                //TODO JOÂO
                //Tratar a data através de "Split" da string "line"
            }
            // Close file
            br.close();
 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public void readDataTest(){
        for (Fatura fatura:Data){
            System.out.println(fatura.toString());
        }
    }
    
    public void sentToTable(Base base){
           base.setData(Data,Columns);
    }
    
    public BufferedReader getBr() {
        return br;
    }
 
    public void setBr(BufferedReader br) {
        this.br = br;
    }
 
 
    public String gettParamDelimiterA() {
        return tParamDelimiterA;
    }
 
    public void settParamDelimiterA(String tParamDelimiterA) {
        this.tParamDelimiterA = tParamDelimiterA;
    }
 
    public String gettDirectory() {
        return tDirectory;
    }
 
    public void settDirectory(String tDirectory) {
        this.tDirectory = tDirectory;
    }

	public List<Fatura> getFaturas() {
		return Data;
	}
}