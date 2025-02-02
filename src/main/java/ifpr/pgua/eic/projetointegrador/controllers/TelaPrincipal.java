package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaPrincipal extends BaseController {

    @FXML
    private void carregarAreas(){
        App.changeScreenRegion("AREAS", BorderPaneRegion.CENTER);
    }
    
    @FXML
    private void carregarFuncionarios(){
        App.changeScreenRegion("FUNCIONARIOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregarTelaLogin(){
        App.changeScreenRegion("LOGIN", BorderPaneRegion.CENTER);
    }

    public void dispose(ActionEvent e) {
        dispose(e);
    }

    public void setVisible(boolean b) {
        setVisible(false);
    }

}
