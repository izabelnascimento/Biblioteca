package biblioteca;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tela extends JFrame{
    
    private static final long serialVersionUID = 1L;
    private JLabel lbNome;
    private JLabel lbAtendimento;
    private JLabel lbNumAtendimento;
    private JLabel lbClienteVez;
    private JLabel lbCPF;
    private JLabel lbLivro;
    private JLabel lbQuantT;
    private JLabel lbQuantN;
    private JLabel lbLista;
    private JTextField tfNome;
    private JTextField tfCPF;
    private JTextField tfLivro;
    private JButton btInserir;
    private JButton btProximo;
    private JButton btConfirmar;
    private JScrollPane barraRolagem;
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();
    
    public Tela(){
        this.setTitle("Tela de atendimento bibliotecário");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(650, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        this.lbNome = new JLabel("Nome:");
        this.lbNome.setBounds(20, 20, 150, 20);
        this.lbAtendimento = new JLabel ("Atendimento: ");
        this.lbAtendimento.setBounds(20, 135, 150, 20);
        this.lbNumAtendimento = new JLabel ("00");
        this.lbNumAtendimento.setBounds(100, 135, 150, 20);
        this.lbClienteVez = new JLabel ("-------------");
        this.lbClienteVez.setBounds(120, 135, 150, 20);
        this.lbCPF = new JLabel("CPF: ");
        this.lbCPF.setBounds(20, 160, 150, 20);
        this.lbLivro = new JLabel("Livro: ");
        this.lbLivro.setBounds(20, 185, 150, 20);
        this.lbQuantT = new JLabel ("Quantidade de pessoas na fila: ");
        this.lbQuantT.setBounds(250, 95, 200, 20);
        this.lbQuantN = new JLabel ("0");
        this.lbQuantN.setBounds(430, 95, 150, 20);
        this.lbLista = new JLabel ("LISTA DE ATENDIMENTOS FEITOS");
        this.lbLista.setBounds(220, 240, 200, 20);
        this.btInserir = new JButton("Inserir na fila");
        this.btInserir.setBounds(400, 40, 200, 25);
        this.btProximo = new JButton("Chamar próximo");
        this.btProximo.setBounds(20, 85, 200, 25);
        this.btConfirmar = new JButton("Confirmar");
        this.btConfirmar.setBounds(300, 185, 100, 25);
        this.tfNome = new JTextField("");
        this.tfNome.setBounds(20, 40, 350, 25);
        this.tfCPF = new JTextField("");
        this.tfCPF.setBounds(70, 160, 150, 20);
        this.tfLivro = new JTextField("");
        this.tfLivro.setBounds(70, 185, 200, 20);
        
        criarTabela();
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(20, 270, 580, 280);
        
        this.add(lbNome);
        this.add(lbAtendimento);
        this.add(lbNumAtendimento);
        this.add(lbClienteVez);
        this.add(lbCPF);
        this.add(lbLivro);
        this.add(lbLista);
        this.add(btInserir);
        this.add(btProximo);
        this.add(btConfirmar);
        this.add(lbQuantT);
        this.add(lbQuantN);
        this.add(tfNome);
        this.add(tfCPF);
        this.add(tfLivro);
        this.add(barraRolagem);
        
        setVisible(true);
    }
    
    public void limparCampos(){
        tfNome.setText("");
        tfCPF.setText("");
        tfLivro.setText("");
    }
    
    public void exibirAlerta(String mensagem){
        JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    private void criarTabela() {
        tabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome do Cliente");
        modelo.addColumn("CPF");
        modelo.addColumn("Nome do livro");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(260);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(140);
    }
    
    public void adicionarClienteTabela(Cliente cliente, Atendimento livro){
        modelo.addRow(new Object[] { cliente.getCodigo(), cliente.getNome(), cliente.getCpf(), livro.getNomeLivro()});
    }
    
    public void atualizarTabela(ListaDinamica atendimentos){
        modelo.setRowCount(0);
        for(int i = 0; i< atendimentos.getTamanho(); i++){
            modelo.addRow(new Object[] { atendimentos.get(i).getCodigo(), atendimentos.get(i).getCliente(),
            atendimentos.get(i).getCpf(), atendimentos.get(i).getNomeLivro()});
            
        }
    }

    public JLabel getLbNome() {
        return lbNome;
    }

    public void setLbNome(JLabel lbNome) {
        this.lbNome = lbNome;
    }

    public JLabel getLbAtendimento() {
        return lbAtendimento;
    }

    public void setLbAtendimento(JLabel lbAtendimento) {
        this.lbAtendimento = lbAtendimento;
    }

    public JLabel getLbCPF() {
        return lbCPF;
    }

    public void setLbCPF(JLabel lbCPF) {
        this.lbCPF = lbCPF;
    }

    public JLabel getLbLivro() {
        return lbLivro;
    }

    public void setLbLivro(JLabel lbLivro) {
        this.lbLivro = lbLivro;
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(JTextField tfNome) {
        this.tfNome = tfNome;
    }

    public JTextField getTfCPF() {
        return tfCPF;
    }

    public void setTfCPF(JTextField tfCPF) {
        this.tfCPF = tfCPF;
    }

    public JTextField getTfLivro() {
        return tfLivro;
    }

    public void setTfLivro(JTextField tfLivro) {
        this.tfLivro = tfLivro;
    }

    public JButton getBtInserir() {
        return btInserir;
    }

    public void setBtInserir(JButton btInserir) {
        this.btInserir = btInserir;
    }

    public JButton getBtProximo() {
        return btProximo;
    }

    public void setBtProximo(JButton btProximo) {
        this.btProximo = btProximo;
    }

    public JButton getBtConfirmar() {
        return btConfirmar;
    }

    public void setBtConfirmar(JButton btConfirmar) {
        this.btConfirmar = btConfirmar;
    }

    public JScrollPane getBarraRolagem() {
        return barraRolagem;
    }

    public void setBarraRolagem(JScrollPane barraRolagem) {
        this.barraRolagem = barraRolagem;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public JLabel getLbClienteVez() {
        return lbClienteVez;
    }

    public void setLbClienteVez(JLabel lbClienteVez) {
        this.lbClienteVez = lbClienteVez;
    }

    public JLabel getLbNumAtendimento() {
        return lbNumAtendimento;
    }

    public void setLbNumAtendimento(JLabel lbNumAtendimento) {
        this.lbNumAtendimento = lbNumAtendimento;
    }

    public JLabel getLbQuantT() {
        return lbQuantT;
    }

    public void setLbQuantT(JLabel lbQuantT) {
        this.lbQuantT = lbQuantT;
    }

    public JLabel getLbQuantN() {
        return lbQuantN;
    }

    public void setLbQuantN(JLabel lbQuantN) {
        this.lbQuantN = lbQuantN;
    }
    
}
