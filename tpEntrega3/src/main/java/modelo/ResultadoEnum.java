package modelo;


public class ResultadoEnum {

    Resultado res;

    public enum Resultado {
        GANA1, EMPATA, GANA2 
    }
  
    
    public ResultadoEnum(Resultado r) {
        this.res = r;
    }
    
    public void tellItLikeItIs() {
        switch (res) {
            case GANA1:
                System.out.println("GANADOR");
                break;
                    
            case EMPATA:
                System.out.println("EMPATE");
                break;
                         
            case GANA2: 
                System.out.println("PERDEDOR");
                break;  
        }
    }
}