package lists;

public class DynamicList {
    private int quantidade;
    private No inicio;
    private No fim;

    public DynamicList() {
        this.inicio = this.fim = null;
        this.quantidade = 0;
    }
    
    public int size() {
        return quantidade;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean exist(int elemento) {
        No auxiliar = inicio;

        while (auxiliar != null) {
            if (auxiliar.dado == elemento) {
                return true;
            }
            auxiliar = auxiliar.proximo;
        }
        return false;
    }

    public boolean add(int novoElemento, int posicao) {
        if (posicao > size() || posicao < 0) {
            return false;
        }

        No novo = new No(novoElemento);
        if (posicao == 0 && isEmpty()) {
            inicio = fim = novo;
        } else {
            if (posicao == 0) {
                novo.proximo = this.inicio;   //Proximo elemento do novo nó = inicio
                this.inicio = novo;           //Inicio = novo nó
            } else {
                if (posicao == size()) {
                    this.fim.proximo = novo;  //Proximo elemento do fim = novo nó
                    fim = novo;               //Fim = novo nó
                } else {
                    No anterior = inicio;
                    //Percorrendo até o nó anterior ao local a ser inserido
                    for (int i = 0; i < posicao - 1; i++) {
                        anterior = anterior.proximo;
                    }

                    novo.proximo = anterior.proximo;  //Proximo elemento do novo nó = proximo do seu anterior
                    anterior.proximo = novo;          //Proximo do anterio = novo nó
                }
            }
        }
        quantidade++;
        return true;
    }

    public void add(int novoElemento) {
        No novo = new No(novoElemento);

        if (isEmpty()) {
            inicio = fim = novo; //Se estiver vazio -> inicio e fim são iguais ao novo nó
        } else {
            fim.proximo = novo; //Proximo do fim = novo nó
            fim = novo;         //Novo nó se torna o último elemento
        }
        quantidade++;
    }

    public int remove(int posicao) {
        if (isEmpty() || posicao > size() || posicao < 0) {
            new Error("Inválido");
        } else {
            int temporario;

            if (posicao == 0 && size() == 1) {
                temporario = inicio.dado;
                inicio = fim = null;
                return temporario;
            } else {
                if (posicao == 0) {
                    temporario = inicio.dado;
                    inicio = inicio.proximo;
                } else {
                    int contador = 0;
                    No auxiliar = inicio;
                    while (contador < posicao - 1) {
                        contador++;
                        auxiliar = auxiliar.proximo;
                    }

                    No removido = auxiliar.proximo;
                    temporario = removido.dado;
                    auxiliar.proximo = removido.proximo;
                }

                quantidade--;
                return temporario;
            }
        }

        return 0;
    }

    public boolean set(int novoValor, int posicao) {
        if (isEmpty() || posicao >= size()) {
            return false;
        }

        int contador = 0;
        No auxiliar = inicio;
        while (contador < posicao) {
            contador++;
            auxiliar = auxiliar.proximo;
        }

        auxiliar.dado = novoValor;

        return true;
    }

    public int get(int posicao) throws Exception {
        if (posicao < size() && !isEmpty() && posicao >= 0) {
            int contador = 0;
            No auxiliar = inicio;
            while (contador < posicao) {
                contador++;
                auxiliar = auxiliar.proximo;
            }
            
            return auxiliar.dado;
        }else{
            throw new Exception("Deu pau");
        }
    }

    public String imprimir() {
        StringBuilder valores = new StringBuilder();
        valores.append('(');
        No auxiliar = inicio;
        while (auxiliar != null) {
            valores.append(auxiliar.dado);
            if (auxiliar != fim) {
                valores.append(", ");
            }
            auxiliar = auxiliar.proximo;
        }
        valores.append(")");
        return valores.toString();
    } 
}
