package net.codejava.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegistroImc {

    private Long id;
    private String name;
    private String edad;
    private String sexo;
    private float estatura;
    private float peso;
    private float imc;
    private String fecha;
    private String resultado;
    public RegistroImc() {
        
    }

    protected RegistroImc(Long id, String name, String edad, String sexo, float estatura, float peso) {
        super();
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.sexo = sexo;
        this.estatura = estatura;
        this.peso=peso;
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
     public String Fecha(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = dtf.format(LocalDateTime.now());
        
        return fecha;
    }
    
     public String ResultadoIMC(){
         if (imc>25){
             return "Sobrepeso";
         }
         else if (imc>18.5){
             return "peso normal";
         }
         else {
             return "Peso bajo";
         }
     }
     public void ImcYFecha(){
        imc= peso/(estatura*estatura);
        fecha=Fecha();
        resultado= ResultadoIMC();
     }
}
