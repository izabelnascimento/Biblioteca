package biblioteca;

public class FilaDinamica <T> {
    
    private int tamanho = 0;
    private No fim, inicio;

    
    public boolean isVazia() {
    	return tamanho == 0;
    }
    
    public int getTamanho(){
        return tamanho;
    }
    
    public void inserir(T t) {
        No no = new No();
        no.t = t;
        no.proximo = null;
        if(isVazia()){
            inicio = no;
            fim = no;
        }else{
            // para entender essa proxima linha é imaginar que a fila estará linkada da seguinte forma: 
            // no.proximo = null; aponta para -> fim.proximo = no; aponta para -> fim.proximo = no; e assim sucessivamente
            fim.proximo = no;
            fim = no;
        }
        tamanho++;
    }
    
    public boolean remover() {
        if(isVazia()) {
            return false;
    }
        inicio = inicio.proximo;
        // aponto o fim para nulo caso o tamanho da fila passe a ser 1
        if(tamanho == 1){
            fim = null;
        }
        tamanho--;
        return true;
    }
    
    public T get() {
	    if(isVazia()) {
            return null;
	    }
        // chamo o t para ele poder identificar qual o elemento dentro da classe Elemento deve ser retornado
	    return inicio.t;
    }
    
    private class No{
        No proximo;
        private T t;
    }
    
}
