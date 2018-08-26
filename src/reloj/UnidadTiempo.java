package reloj;

public abstract class UnidadTiempo {

    public int getLimite() {
        return limite;
    }

    public UnidadTiempo(int limite, int valor) {
        this.limite = limite;
        this.valor = valor;
    }

    public UnidadTiempo() {
    }

    protected void setLimite(int limite) {
        if(limite<=0){
            limite = Math.abs(limite);
        }
        this.limite = limite;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if(valor<0){
            valor=0;
        }
        this.valor = valor;
    }

    public void avanzar() {
        valor++;
        if (valor == limite) {
            valor = 0;
        }
    }

    public void retroceder() {
        valor--;
        if (valor == -1) {
            valor = limite - 1;
        }
    }

    public void reiniciar() {
        valor = 0;
    }

    private int limite;

    private int valor;

}
