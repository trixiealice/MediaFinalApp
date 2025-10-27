package br.senai.sp.jandira.mediafinal.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaMediaFinal extends Application {


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

        TextField tfNomeAluno = new TextField();
        TextField tfNota1 = new TextField();
        TextField tfNota2 = new TextField();
        TextField tfNota3 = new TextField();
        TextField tfNota4 = new TextField();
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

        VBox painelResultado = new VBox();
        painelResultado.setStyle("-fx-background-color: #ccccff");
        Label lblResultados = new Label("Resultados");
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
    }
}