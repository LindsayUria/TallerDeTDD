package ucb.edu.bo.tallertdd1;

public class Calculadora {
    public String suma(String sumandos) throws Exception{
        if (sumandos!= null & sumandos.equals(""))
            return "0";
        else{
            int suma = 0;
            String[] args=sumandos.split(",");
            for (int i=0; i<args.length;i++){
                int x = new Integer(args[i]);
                if (x<=1000) {
                    suma = suma + x;
                }
                if (x<0){
                    throw new Exception("Numero negativo");
                }
            }
            return (new Integer(suma)).toString();
        }
    }
}
