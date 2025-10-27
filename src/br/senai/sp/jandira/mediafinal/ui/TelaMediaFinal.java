package br.senai.sp.jandira.mediafinal.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.html.Option;
import java.util.Optional;

public class TelaMediaFinal extends Application {

    VBox painelResultado;
    TextField tfNomeAluno;
    TextField tfNota1;
    TextField tfNota2;
    TextField tfNota3;
    TextField tfNota4;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(600);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.setTitle("Média Final");

        // Criar o painel principal (root)
        BorderPane root = new BorderPane();

        // Criar o label com o titulo da tela
        Label titulo = new Label();
        titulo.setText("Escola SENAI \"Prof. Vicente Amato\"");
        titulo.setStyle("-fx-font-size: 22; -fx-text-fill: white");
        titulo.setPadding(new Insets(10, 0, 10, 10));

        HBox painelSuperior = new HBox();
        painelSuperior.setStyle("-fx-background-color: #7f7fff");
        painelSuperior.getChildren().addAll(titulo);


        // Crição formulário
        VBox painelFormulario = new VBox();
        painelFormulario.setPadding(new Insets(10));
        painelFormulario.setStyle("-fx-background-color: #b2b2ff");
        Label lblNomeAluno = new Label("Nome do aluno:");
        Label lblNota1 = new Label("Nota 1:");
        Label lblNota2 = new Label("Nota 2:");
        Label lblNota3 = new Label("Nota 3:");
        Label lblNota4 = new Label("Nota 4:");

        tfNomeAluno = new TextField();
        tfNota1 = new TextField();
        tfNota2 = new TextField();
        tfNota3 = new TextField();
        tfNota4 = new TextField();
        painelFormulario.getChildren().addAll(
                lblNomeAluno, tfNomeAluno,
                lblNota1, tfNota1,
                lblNota2, tfNota2,
                lblNota3, tfNota3,
                lblNota4, tfNota4

        );

        VBox painelBotoes = new VBox();
        painelBotoes.setSpacing(15);
        painelBotoes.setAlignment(Pos.CENTER);
        painelBotoes.setStyle("-fx-background-color: #b2b2ff");


        Button btCalcularMedia = new Button("Calcular média");
        btCalcularMedia.setPrefWidth(150);
        btCalcularMedia.setPrefHeight(100);
        btCalcularMedia.setPadding(new Insets(0, 10, 0, 0));

        Button btLimpar = new Button("Limpar");
        btLimpar.setPrefWidth(150);
        btLimpar.setPrefHeight(70);

        Button btSair = new Button("Sair");
        btSair.setPrefWidth(150);
        btSair.setPrefHeight(70);




        painelBotoes.getChildren().addAll(
                btCalcularMedia,
                btLimpar,
                btSair);

        painelResultado = new VBox();
        painelResultado.setStyle("-fx-background-color: #ccccff");
        Label lblResultados = new Label("Resultados");
        lblResultados.setStyle("-fx-text-fill: white");
        Label lblNomeResultados = new Label("Nome do aluno: ");
        Label lblMediaFinal = new Label("Média final: ");
        Label lblSituacao = new Label("Situação: ");
        painelResultado.getChildren().addAll(
                lblResultados, lblNomeResultados,
                lblMediaFinal, lblSituacao
        );

        // Adcionando conteúdo ao root
        root.setTop(painelSuperior);
        root.setCenter(painelFormulario);
        root.setRight(painelBotoes);
        root.setBottom(painelResultado);

        // Criar objeto scene
        Scene scene = new Scene(root);


        // colocar a cena no stage
        stage.setScene(scene);
        stage.show();

        // **** INTERCEPTAR CLIQUES NOS BOTÕES ****
        btCalcularMedia.setOnAction(e -> {

            if (validarEntrada()){
                String nomeAluno = tfNomeAluno.getText();
                System.out.println("Nome do aluno: " + nomeAluno);

                lblNomeResultados.setText("nome do aluno: " + nomeAluno);

                String nota1 = tfNota1.getText();
                String nota2 = tfNota2.getText();
                String nota3 = tfNota3.getText();
                String nota4 = tfNota4.getText();

                double media = calcularMedia (nota1, nota2, nota3, nota4);
                String mediaFormatada = String.format("%.2f", media);
                lblMediaFinal.setText("Media final: " + mediaFormatada);

                String situacao = definirSituacao(media);
                lblSituacao.setText("Situação: " + situacao);
            }



        });

        btLimpar.setOnAction(e -> {
            tfNomeAluno.setText("");
            tfNota1.setText("");
            tfNota2.setText("");
            tfNota3.setText("");
            tfNota4.setText("");
            lblNomeResultados.setText("Nome do aluno: ");
            lblMediaFinal.setText("Média Final: ");
            //lblResultados.setText("");
            lblSituacao.setText("Situação: ");
            painelResultado.setStyle("-fx-background-color: #add8e6");
            tfNomeAluno.requestFocus();

        });
        btSair.setOnAction(e -> {

            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> resposta = alerta.showAndWait();

            if (resposta.get() == ButtonType.OK){
                System.exit(0);
            }
            System.out.println(resposta.get().getText());

        });

    }

    private double calcularMedia(String n1, String n2, String n3, String n4) {
        double nota1 = Double.parseDouble(n1);
        double nota2 = Double.parseDouble(n2);
        double nota3 = Double.parseDouble(n3);
        double nota4 = Double.parseDouble(n4);
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        return media;

    }

    private String definirSituacao(double media){
        if (media < 4.0) {
            painelResultado.setStyle("-fx-background-color: #25f352");
            return "REPROVADO";
        } else if (media >= 6.0) {
            painelResultado.setStyle("-fx-background-color: #ea1d1d");
            return "APROVADO";
        } else {
            painelResultado.setStyle("-fx-background-color: #ff933b");


            return "RECUPERAÇÂO";
        }

    }

    private boolean validarEntrada(){
        if (tfNomeAluno.getText().isEmpty()){
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha o nome do aluno!");
            tfNomeAluno.requestFocus();
            return false;

        } else if (tfNota1.getText().isEmpty()) {
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a nota 1 do aluno!");
            tfNota1.requestFocus();
            return false;

        } else if (tfNota2.getText().isEmpty()) {
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a nota 2 do aluno");
            tfNota2.requestFocus();
            return false;

        } else if (tfNota3.getText().isEmpty()) {
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a nota 3 do aluno");
            tfNota3.requestFocus();
            return false;
        }
        return true;
    }

    private void mostrarMensagem(Alert.AlertType tipo, String mensagem){
        Alert alerta = new Alert(tipo, mensagem);
        alerta.showAndWait();
    }
}