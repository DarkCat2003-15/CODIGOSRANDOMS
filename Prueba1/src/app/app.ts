import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Usuario } from './models/usuario';
import { AuthService } from './services/auth-service';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  usuario='';
  clave='';
  mensaje='';
  loginCorrecto= false;

  usuarios: Usuario[]=[];
  usuarioEncontrado?:Usuario;

  constructor(private authService: AuthService){}

  iniciarSesion(){
    this.authService.login(this.usuario, this.clave).subscribe({
      next: (respuesta)=>{
          if (respuesta.status===200){
            this.loginCorrecto=true;
            this.mensaje='Login exitoso';
            this.cargarUsuarios();
          }
      },
      error:()=>{
        this.mensaje='El login fallo. Verifique Usuario y Clave.';
        this.loginCorrecto=false;
      }
    });
  }
cargarUsuarios(){
  this.authService.obtenerUsuarios().subscribe({
    next:(respuesta)=>{
      this.usuarios=respuesta.data;

      this.usuarioEncontrado= this.usuarios.find(
        x=> x.usuario===this.usuario
      );
    },
    error:()=>{
      this.mensaje='Error al cargar usuarios';
    }
    });
  }
}
