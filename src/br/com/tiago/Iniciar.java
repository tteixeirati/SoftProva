package br.com.tiago;

import java.io.File;
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Iniciar {
	private String baseUrl = "";

	private String usuario = "usr14022102";
	//
	private String senha ="soft123" ;
	//
	private boolean slowConnection = true;

	public boolean isSlowConnection() {
		return slowConnection;
	}
	public void insereNoLog(String novoLog)  throws IOException{
		String path = new File(".").getCanonicalPath();
		FileWriter arq = new FileWriter(path+"\\log.txt", true); 
		PrintWriter gravarArq = new PrintWriter(arq); 
		gravarArq.println(getDataFormatadaSimples()+": "+novoLog);
		arq.close();
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
	public String getDataFormatadaSimples(){
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		DateFormat dateFormat = new SimpleDateFormat("ddMMHHmm");
		Date date = new Date();
		return dateFormat.format(date);

	}
	public String getDataFormatadaPorExtenso(){

		String[] diaHoraSeparada = new String[5];
		NumeroPorExtenso numeroPorExtenso=new NumeroPorExtenso();
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmm");
		Date date = new Date();
		diaHoraSeparada[0]=(dateFormat.format(date)).substring(0, 2);
		diaHoraSeparada[1]=(dateFormat.format(date)).substring(2, 4);
		diaHoraSeparada[2]=(dateFormat.format(date)).substring(4, 8);
		diaHoraSeparada[3]=(dateFormat.format(date)).substring(8, 10);
		diaHoraSeparada[4]=(dateFormat.format(date)).substring(10, 12);
		diaHoraSeparada[0]=(numeroPorExtenso.valorPorExtenso(Integer.parseInt(diaHoraSeparada[0]))).toString();
		diaHoraSeparada[1]=(numeroPorExtenso.valorPorExtenso(Integer.parseInt(diaHoraSeparada[1]))).toString();
		diaHoraSeparada[2]=(numeroPorExtenso.valorPorExtenso(Integer.parseInt(diaHoraSeparada[2]))).toString();
		diaHoraSeparada[3]=(numeroPorExtenso.valorPorExtenso(Integer.parseInt(diaHoraSeparada[3]))).toString();
		diaHoraSeparada[4]=(numeroPorExtenso.valorPorExtenso(Integer.parseInt(diaHoraSeparada[4]))).toString();
		return (diaHoraSeparada[0]+diaHoraSeparada[1]+diaHoraSeparada[2]+diaHoraSeparada[3]+diaHoraSeparada[4]);
	}
}
