package biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaControlador {
    
    private Tela tela;
    private int codigoCliente = 1;
    private ListaDinamica lista = new ListaDinamica();
    private FilaDinamica fila = new FilaDinamica();
    
    public TelaControlador(Tela tela){
        this.tela = tela;
        
        this.tela.getBtInserir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nome = tela.getTfNome().getText();
                if(nome.trim().equals("")){
                    tela.exibirAlerta("Informe o nome");
                }else{
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(codigoCliente);
                    cliente.setNome(nome);
                    fila.inserir(cliente);
                    codigoCliente++;
                    tela.limparCampos();
                    tela.getLbQuantN().setText(Integer.toString(fila.getTamanho()));
                }
            }
        });
        this.tela.getBtProximo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(fila.isVazia()){
                    tela.getLbNumAtendimento().setText("0");
                    tela.getLbClienteVez().setText("-------------");
                    tela.exibirAlerta("A fila está vazia.");
                }else{
                    Cliente c = (Cliente)fila.get();
                    fila.remover();
                    tela.getLbClienteVez().setText(c.getNome());
                    tela.getLbNumAtendimento().setText(Integer.toString(c.getCodigo()));
                    tela.getLbQuantN().setText(Integer.toString(fila.getTamanho()));
                }
            }
        });
        this.tela.getBtConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                String cpf = tela.getTfCPF().getText();
                String livro = tela.getTfLivro().getText();
                if(livro.trim().equals("") || cpf.trim().equals("")){
                    tela.exibirAlerta("Informações faltando");
                }else{
                    Atendimento atendimento = new Atendimento();
                    atendimento.setCliente(tela.getLbClienteVez().getText());
                    //int codigo = Integer.parseInt(tela.getLbNumAtendimento().getText());
                    atendimento.setCodigo(Integer.parseInt(tela.getLbNumAtendimento().getText()));
                    atendimento.setNomeLivro(livro);
                    atendimento.setCpf(cpf);
                    lista.adicionar(atendimento);
                    tela.atualizarTabela(lista);
                    //codigo++;
                    tela.limparCampos();
                }
            }
        });
    }
    private void atualizarTela() {
        if(fila.isVazia()){
            tela.getLbAtendimento().setText("Atendimento: ninguém na fila");
        }else{
            tela.getLbAtendimento().setText("Atendimento: " + fila.get().toString());
        }
    }
}
