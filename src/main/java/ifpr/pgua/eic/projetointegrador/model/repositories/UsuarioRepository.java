package ifpr.pgua.eic.projetointegrador.model.repositories;

import javafx.event.ActionEvent;

public class UsuarioRepository {
    
    private void btLoginActionPerformed(ActionEvent evt){
        String nome_usuario, senha_usuario;

        nome_usuario = tfNomeUsuario.getText();
		senha_usuario = tfSenhaUsuario.getText();
		
		UsuarioRepository objusuario = new UsuarioRepository();
		objusuario.set(Nome_usuario(nome_usuario));
		objusuario.set(Senha_usuario(senha_usuario));
		
    }

}
