package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.entities.FabricaDeUsuario;
import br.com.alura.codechella.domain.entities.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){
        Assertions.assertThrows( IllegalArgumentException.class,
                () -> new Usuario("12345678999", "José", LocalDate.parse( "1990-09-08" ), "email@gmail.com" ) );

        Assertions.assertThrows( IllegalArgumentException.class,
                () -> new Usuario("123456.789-99", "José", LocalDate.parse( "1990-09-08" ), "email@gmail.com" ) );

        Assertions.assertThrows( IllegalArgumentException.class,
                () -> new Usuario("", "Augusto", LocalDate.parse( "1990-09-08" ), "email@gmail.com" ) );
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario(){
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento( "987.654.321-11", "Emily", LocalDate.parse( "2000-11-09" ) );

        Assertions.assertEquals( "Emily", usuario.getNome() );

        usuario = fabrica.incluiEndereco( "12345-999", 40, "apto 201" );

        Assertions.assertEquals( "apto 201", usuario.getEndereco().getComplemento() );
    }

}
