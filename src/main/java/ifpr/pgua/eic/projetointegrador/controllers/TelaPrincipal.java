package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BorderPaneRegion;
import javafx.fxml.FXML;

public class TelaPrincipal extends BaseController {

    @FXML
    private void carregarFuncionarios(){
        App.changeScreenRegion("FUNCIONARIOS", BorderPaneRegion.CENTER);
    }
}
