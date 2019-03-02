/*
 * Trabajo de Seguridad Informática. Construcción de una herramienta de cripto-
 * análisis para códigos por sustitución monoalfabética.
 */
package goldenbug;

import com.sun.xml.internal.ws.util.StringUtils;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Alejandro Moya García
 */
public class GoldenBug {

    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private Map<Character,Double> frecuenciasCifrado;
    private Map<Character,Double> frecuenciasIngles;
    private Map<String,Double> frecuencias1gramas;
    private Map<String,Double> frecuencias2gramas;
    private Map<String,Double> frecuencias3gramas;
    private Map<String,Double> frecuenciasPares;
    private Map<Character,Character> mapeadoSolucion;
    private String alfabeto;
    private int claveA;
    private int claveB;
    
    public GoldenBug(){
        this.frecuenciasCifrado= new HashMap();
        this.frecuenciasIngles=new HashMap();
        this.frecuencias1gramas=new HashMap();
        this.frecuencias2gramas=new HashMap();
        this.frecuencias3gramas=new HashMap();
        this.frecuenciasPares=new HashMap();
        this.mapeadoSolucion=new HashMap();
        iniciarFrecuenciasIngles();
        this.alfabeto="abcdefghijklmnopqrstuvwxyz";
    }

    public int getClaveA() {
        return claveA;
    }

    public int getClaveB() {
        return claveB;
    }
    
    public Map<String,Double> getNGramFrecuencias(int ngram){
        if(ngram==1){
            return sortNgram(this.frecuencias1gramas);
        }else if (ngram==2){
            return sortNgram(this.frecuencias2gramas);
        }else if(ngram==3){
            return sortNgram(this.frecuencias3gramas);
        }else{
            return null;
        }
    }
    
    public Map<String,Double> getRepes(){
        return this.frecuenciasPares;
    }
    
    
    
    /**
     * Rellena el mapeado con las frecuencias de aparicion de letras individuales
     * en ingles
     */
    public void iniciarFrecuenciasIngles(){
        this.frecuenciasIngles.put('a',8.167);
        this.frecuenciasIngles.put('b',1.492);
        this.frecuenciasIngles.put('c',2.782);
        this.frecuenciasIngles.put('d',4.253);
        this.frecuenciasIngles.put('e',12.702);
        this.frecuenciasIngles.put('f',2.228);
        this.frecuenciasIngles.put('g',2.015);
        this.frecuenciasIngles.put('h',6.094);
        this.frecuenciasIngles.put('i',6.996);
        this.frecuenciasIngles.put('j',0.153);
        this.frecuenciasIngles.put('k',0.772);
        this.frecuenciasIngles.put('l',4.025);
        this.frecuenciasIngles.put('m',2.406);
        this.frecuenciasIngles.put('n',6.749);
        this.frecuenciasIngles.put('o',7.507);
        this.frecuenciasIngles.put('p',1.929);
        this.frecuenciasIngles.put('q',0.095);
        this.frecuenciasIngles.put('r',5.987);
        this.frecuenciasIngles.put('s',6.327);
        this.frecuenciasIngles.put('t',9.056);
        this.frecuenciasIngles.put('u',2.758);
        this.frecuenciasIngles.put('v',0.978);
        this.frecuenciasIngles.put('w',2.360);
        this.frecuenciasIngles.put('x',0.150);
        this.frecuenciasIngles.put('y',1.974);
        this.frecuenciasIngles.put('z',0.074);
        
        
        this.frecuencias1gramas.put("a",8.167);
        this.frecuencias1gramas.put("b",1.492);
        this.frecuencias1gramas.put("c",2.782);
        this.frecuencias1gramas.put("d",4.253);
        this.frecuencias1gramas.put("e",12.702);
        this.frecuencias1gramas.put("f",2.228);
        this.frecuencias1gramas.put("g",2.015);
        this.frecuencias1gramas.put("h",6.094);
        this.frecuencias1gramas.put("i",6.996);
        this.frecuencias1gramas.put("j",0.153);
        this.frecuencias1gramas.put("k",0.772);
        this.frecuencias1gramas.put("l",4.025);
        this.frecuencias1gramas.put("m",2.406);
        this.frecuencias1gramas.put("n",6.749);
        this.frecuencias1gramas.put("o",7.507);
        this.frecuencias1gramas.put("p",1.929);
        this.frecuencias1gramas.put("q",0.095);
        this.frecuencias1gramas.put("r",5.987);
        this.frecuencias1gramas.put("s",6.327);
        this.frecuencias1gramas.put("t",9.056);
        this.frecuencias1gramas.put("u",2.758);
        this.frecuencias1gramas.put("v",0.978);
        this.frecuencias1gramas.put("w",2.360);
        this.frecuencias1gramas.put("x",0.150);
        this.frecuencias1gramas.put("y",1.974);
        this.frecuencias1gramas.put("z",0.074);
        
        this.frecuencias2gramas.put("th", 1.52);
        this.frecuencias2gramas.put("he", 1.28);
        this.frecuencias2gramas.put("in", 0.94);
        this.frecuencias2gramas.put("er", 0.94);
        this.frecuencias2gramas.put("an", 0.82);
        this.frecuencias2gramas.put("re", 0.68);
        this.frecuencias2gramas.put("nd", 0.63);
        this.frecuencias2gramas.put("at", 0.59);
        this.frecuencias2gramas.put("on", 0.57);
        this.frecuencias2gramas.put("nt", 0.56); 
        this.frecuencias2gramas.put("ha", 0.56);
        this.frecuencias2gramas.put("es", 0.56);
        this.frecuencias2gramas.put("st", 0.55);
        this.frecuencias2gramas.put("en", 0.55);
        this.frecuencias2gramas.put("ed", 0.53);
        this.frecuencias2gramas.put("to", 0.52); 
        this.frecuencias2gramas.put("it", 0.50);
        this.frecuencias2gramas.put("ou", 0.50);
        this.frecuencias2gramas.put("ea", 0.47);
        this.frecuencias2gramas.put("hi", 0.46);
        this.frecuencias2gramas.put("is", 0.46);
        this.frecuencias2gramas.put("or", 0.43);
        this.frecuencias2gramas.put("ti", 0.34);
        this.frecuencias2gramas.put("as", 0.33);
        this.frecuencias2gramas.put("te", 0.27);
        this.frecuencias2gramas.put("et", 0.19);
        
        this.frecuencias3gramas.put("the", 4.0);
        this.frecuencias3gramas.put("and", 3.0);
        this.frecuencias3gramas.put("for", 2.0);
        this.frecuencias3gramas.put("you", 1.0);
        
        this.frecuenciasPares.put("ll", 7.0);
        this.frecuenciasPares.put("ee", 6.0);
        this.frecuenciasPares.put("ss", 5.0);
        this.frecuenciasPares.put("oo", 4.0);
        this.frecuenciasPares.put("tt", 3.0);
        this.frecuenciasPares.put("ff", 2.0);
        this.frecuenciasPares.put("rr", 1.0);
      
    }
    
    /**
     * Calcula las frecuencias del texto cifrado
     * @param textoCifrado
     */
    public void calcularFrecuencias(String textoCifrado){
        for(int i=0;i<textoCifrado.length();i++){
            Character c= textoCifrado.charAt(i);
            if(this.frecuenciasCifrado.containsKey(c)){
                this.frecuenciasCifrado.put(c, (double)(this.frecuenciasCifrado.get(c).intValue()+1));
            }else{
                this.frecuenciasCifrado.put(c,1.0);
            }
        }
    }
    /**
     * Calcula las frecuencias del texto cifrado de bloques de longitud ngrama
     * @param textoCifrado
     * @param longitud
     */
    public Map<String,Double> calcularFrecuenciasNgramas(String textoCifrado, int longitud){
        Map<String,Double> map=new HashMap();
        int numIter=textoCifrado.length()/longitud;
        String aux=textoCifrado;
        
        for(int i=0;i<longitud;i++){
            aux=textoCifrado.substring(i,textoCifrado.length());
            
            for(int j=0;j<numIter;j++){
                if(aux.length()>=longitud){
                    String token=aux.substring(0, longitud);
                if(map.containsKey(token)){
                    map.put(token, (double)(map.get(token).intValue()+1));
                }else{
                    map.put(token,1.0);
                }
                aux=aux.substring(longitud,aux.length());
                }
                
            }
        }
        return map;
    }
    
    public Map<String,Double> calcularFrecuenciasRepes(String textoCifrado){
        Map<String,Double> map=new HashMap();
        
        for(int i=0;i<this.alfabeto.length();i++){
            String pair=""+this.alfabeto.charAt(i)+this.alfabeto.charAt(i);
            int veces = 0;
            int fromIndex=0;
            while ((fromIndex = textoCifrado.indexOf(pair, fromIndex)) != -1 ){
                veces++;
                fromIndex++;
            
            }
            if(veces!=0){
                map.put(pair,(double)veces);
            }
            
   
        }
        return map;
    }
    
    
    
    /**
     * Devuelve un mapeado con las numValores letras que mas aparecen en el texto cifrado
     * y sus correspondientes valores
     * @param numValores
     * @return 
     */
    public Map<Character,Character> getMayoresFrecuencias(int numValores){
        Map<Character,Character> map=new HashMap();
        this.frecuenciasCifrado=sort(this.frecuenciasCifrado);
        this.frecuenciasIngles=sort(this.frecuenciasIngles);
        Iterator<Entry<Character,Double>> entradasCifrado =this.frecuenciasCifrado.entrySet().iterator();
        Iterator<Entry<Character,Double>> entradasIngles =this.frecuenciasIngles.entrySet().iterator();
        for(int i=0;i<numValores;i++){
            map.put(entradasCifrado.next().getKey(),entradasIngles.next().getKey());
        }
        return map;
    }
    
    
    /**
     * Ordena el mapeado por frecuencia de aparición
     * @param map
     * @return el mapeado ordenado
     */
    public  Map<Character, Double> sort(Map<Character,Double> map) {
        LinkedList<Map.Entry<Character, Double>> list =
                new LinkedList<Map.Entry<Character, Double>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Double>>() {
            public int compare(Map.Entry<Character, Double> o1,
                               Map.Entry<Character, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

       
        Map<Character, Double> sortedMap = new LinkedHashMap<Character, Double>();
        for (Map.Entry<Character, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
    
    /**
     * Ordena el mapeado por frecuencia de aparición
     * @param map
     * @return el mapeado ordenado
     */
    public  Map<String, Double> sortNgram(Map<String,Double> map) {
        LinkedList<Map.Entry<String, Double>> list =
                new LinkedList<Map.Entry<String, Double>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

       
        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
    
    /**
     * Convierte a String un mapa
     * @param map
     * @return el map en string
     */
    public String mapToString(Map<Character,Double> map){
         String result="";
        for (Map.Entry<Character, Double> entry : map.entrySet()) {
                 result+=entry.getKey() + "=" + entry.getValue()+"\n";
        }
        
        return result;
     }
    
    /**
     * Coge las 25 primeras entradas de un map
     * @param map
     * @return 
     */
    public Map<String,Double> reduce(Map<String,Double> map){
        Map<String,Double> reduced=new LinkedHashMap();
        int numIter=0;
        for(Map.Entry<String,Double> entry: map.entrySet()){
            reduced.put(entry.getKey(), entry.getValue());
            numIter++;
            if(numIter==25){
                break;
            }
        }
        return reduced;
    }
    
    public void calcularClaveCifrado(){
        Map<Character,Character> map=getMayoresFrecuencias(2);
        Iterator<Entry<Character,Character>> entradas =map.entrySet().iterator();
        Entry<Character,Character> entrada=entradas.next();
        
        char letraCifrada1=entrada.getKey();
        char letraDescifrada1=entrada.getValue();
        entrada=entradas.next();
        
        char letraCifrada2=entrada.getKey();
        char letraDescifrada2=entrada.getValue();
        
        int letraCifrada1Num=this.alfabeto.indexOf(letraCifrada1);
        int letraCifrada2Num=this.alfabeto.indexOf(letraCifrada2);
        int letraDescifrada1Num=this.alfabeto.indexOf(letraDescifrada1);
        int letraDescifrada2Num=this.alfabeto.indexOf(letraDescifrada2);
        
        
        int a=letraCifrada2Num-letraCifrada1Num;
        int auxA=inverso(letraDescifrada2Num-letraDescifrada1Num,this.alfabeto.length());
        a=Math.floorMod(a*auxA,this.alfabeto.length());

        int b=Math.floorMod(letraCifrada1Num-a*letraDescifrada1Num, this.alfabeto.length());
      
        this.claveA=a;
        this.claveB=b;
    }
    
    /**
     * Devuelve un map con la tabla de descifrado
     * @param textoCifrado
     * @return textoDescifrado
     */
    public Map<Character,Character> descifrar(String textoCifrado){
        this.calcularFrecuencias(textoCifrado);
        this.calcularClaveCifrado();
        for(int i=0;i<alfabeto.length();i++){
           int letraCifradaNum=Math.floorMod(i*this.claveA+this.claveB,this.alfabeto.length());
           this.mapeadoSolucion.put(this.alfabeto.charAt(letraCifradaNum),alfabeto.charAt(i));
            
        }
        
        return this.mapeadoSolucion;
    }
    
    /**
     * Calcula el inverso modulo mod
     * @param num
     * @param mod
     * @return el inverso
     */
    public int inverso(int num, int mod){
        num=Math.floorMod(num,mod);
        return  Math.floorMod(inversoAux(mod, num, 0,1,1,0),mod);
    }
    
    
    /**
     * 
     * @param resto_2 el modulo
     * @param resto_1 el numero que se quiere saber su inverso
     * @param landa_1
     * @param mu_1
     * @param landa_2
     * @param mu_2
     * @return 
     */
    
    public int inversoAux(int resto_2, int resto_1,int landa_1, int mu_1,int landa_2, int mu_2){
        if(resto_2==1){
            return mu_2;//Seria el mu_1 en la anterior iteracion
        }
        int nuevo_landa_1=landa_2-(resto_2/resto_1*landa_1);
        int nuevo_mu_1=mu_2-(resto_2/resto_1)*mu_1;
        /*System.out.println("resto2: "+resto_2+" resto1: "+resto_1+" landa_1:"+landa_1+
                " landa_2:"+landa_2+" mu_1:"+mu_1+" mu_2:"+mu_2+" nuevo_landa_1:"+nuevo_landa_1+" nuevo_mu_1:"+nuevo_mu_1+" cociente:"+resto_2/resto_1);*/
        return inversoAux(resto_1,Math.floorMod(resto_2,resto_1),nuevo_landa_1,nuevo_mu_1,landa_1,mu_1);
    }
}
