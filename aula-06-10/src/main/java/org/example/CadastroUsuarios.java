package org.example;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CadastroUsuarios implements Iterable<Usuario>{
    private List<Usuario> users;
    
    private void inicializa(String fName)throws IOException{
        File file = new File(fName);
        Scanner s = new Scanner(file);
    	String line = s.nextLine();
        while(s.hasNextLine()){
        	line = s.nextLine();
        	StringTokenizer st = new StringTokenizer(line,",");
        	int id = Integer.parseInt(st.nextToken());
        	String nome = st.nextToken();
        	String sobrenome = st.nextToken();
        	String email = st.nextToken();
        	String sexo = st.nextToken();
        	String ip = st.nextToken();
            Usuario u = new Usuario(id,nome,sobrenome,email,sexo,ip);
            users.add(u);
        }
        s.close();
    }
    
    public CadastroUsuarios()throws IOException{
    	users = new LinkedList<>();
    	inicializa("pessoas.txt");
    }

    // Letra a    
    @Override
    public Iterator<Usuario> iterator(){
    	return users.iterator();
    }
    
    public int quantidade(){
        return users.size();
    }
    
    // Letra b
    public int removePorIp(int nro){
        int cont = 0;
        Iterator<Usuario> it = users.iterator();
        while (it.hasNext()){
            Usuario user = it.next();
            String[] split = user.getIp().split(".");

            if (split.equals(nro)){
                it.remove();
                cont++;
            }
        }

        return cont;
    }
    
    // Letra c
    public void insere(String nome, String sobrenome, Usuario novo){
        Iterator<Usuario> it = users.iterator();

        while(it.hasNext()){
            Usuario user = it.next();
            if(nome.equals(user.getNome()) && sobrenome.equals(user.getSobrenome())){
                users.add(users.indexOf(user) + 1, novo);
            }
        }

    }
    
    // Letra d 
    public void ordena(){
        Collections.sort(users);
    }

    //letra e
    public void random(){
        Collections.shuffle(users);
    }

    //letra e
    public void inverter(){
        Collections.reverse(users);
    }

    @Override
    public String toString(){
    	return users.toString();
    }
}
