package biblioteca;

public class ListaDinamica {
    
    private No primeiro = null;

    public int getQuantidadeAtendimentos() {
        int quantidadeAtendimentos = 0;
	No aux = primeiro;
        while(aux != null) {
            quantidadeAtendimentos++;
            aux = aux.proximo;
	}
        return quantidadeAtendimentos;
    }

    public int getTamanho() {
        return getQuantidadeAtendimentos();
    }
    
    public boolean isVazia() {
        return primeiro == null;
    }

    public boolean isCheia() {
        return false;
    }

    public boolean adicionar(Atendimento atendimento) {
        No no = new No();
	no.atendimento = atendimento;
        no.proximo = null;
	if(isVazia()) {
            primeiro = no;
	}else {
            No aux = primeiro;
            // mesmo que eu tá estanciando um objeto
            //No aux = new No();
            // aux = primeiro;
            while(aux.proximo != null) {
		aux = aux.proximo;
            }
            aux.proximo = no;
	}
        return true;
    }

    public boolean remover(int codigoAtendimento) {
        No aux = primeiro;
	No auxAnterior = null;
        while(aux != null && aux.atendimento.getCodigo() != codigoAtendimento) {
            auxAnterior = aux;
            aux = aux.proximo;
	}
        if(aux == null) {
            return false;
	}
        // Pequena alteração nessa linha em relação a aula.
	// Na condicional troquei o getQuantidadeProdutos() == 1 por aux == primeiro
        if(aux == primeiro) {
            primeiro = aux.proximo;
	}else {			
            auxAnterior.proximo = aux.proximo;
	}
        return true;
    }

    public Atendimento get(int i) {
        if(i < 0 || i >= getQuantidadeAtendimentos()) {
            return null;
	}
        No aux = primeiro;
	int indice = 0;
        while(aux != null && indice < i ) {
            aux = aux.proximo;
            indice++;
	}
        if(aux == null) {
            return null;
	}
        return aux.atendimento;
    }
	
    private class No {
        Atendimento atendimento;
        No proximo;
    }

    public Atendimento get(String descricaoLivro) {
        return null;
    }

    public Atendimento getCodigo(int codigo) {
        return null;
    }
    
}
