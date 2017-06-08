package zioncosta.trabajopractico3;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    ImageButton[] ArrayBotones = new ImageButton[9];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayBotones[0] = (ImageButton) findViewById(R.id.Boton1);
        ArrayBotones[1] = (ImageButton) findViewById(R.id.Boton2);
        ArrayBotones[2] = (ImageButton) findViewById(R.id.Boton3);
        ArrayBotones[3] = (ImageButton) findViewById(R.id.Boton4);
        ArrayBotones[4] = (ImageButton) findViewById(R.id.Boton5);
        ArrayBotones[5] = (ImageButton) findViewById(R.id.Boton6);
        ArrayBotones[6] = (ImageButton) findViewById(R.id.Boton7);
        ArrayBotones[7] = (ImageButton) findViewById(R.id.Boton8);
        ArrayBotones[8] = (ImageButton) findViewById(R.id.Boton9);
        for (int i = 0; i <= 8; i++)
        {
            ArrayBotones[i].setEnabled(false);
        }
    }

    public void NombreIngresado(View view)
    {
        EditText TextoNombre = (EditText) findViewById(R.id.TextoNombre);
        String StringNombre = TextoNombre.getText().toString();
        if (StringNombre.matches(""))
        {
            Toast MensajeError;
            MensajeError = Toast.makeText(this, "Ingresá un nombre para comenzar lo dice ahí papu", Toast.LENGTH_SHORT);
            MensajeError.show();
        }
        else
        {
            for (int i = 0; i <= 8; i++)
            {
                ArrayBotones[i].setEnabled(true);
            }
            AsignarImagen();
            Toast Bienvenida;
            Bienvenida = Toast.makeText(this, "Bienvenido/a " + StringNombre, Toast.LENGTH_SHORT);
            Bienvenida.show();
        }
    }

    void AsignarImagen() //Funciona hiper perfecto
    {
        for (int i = 0; i <= 8; i++)
        {
            switch (i)
            {
                case 0:
                    AsignarImagenABoton(R.id.Boton1);
                    break;
                case 1:
                    AsignarImagenABoton(R.id.Boton2);
                    break;
                case 2:
                    AsignarImagenABoton(R.id.Boton3);
                    break;
                case 3:
                    AsignarImagenABoton(R.id.Boton4);
                    break;
                case 4:
                    AsignarImagenABoton(R.id.Boton5);
                    break;
                case 5:
                    AsignarImagenABoton(R.id.Boton6);
                    break;
                case 6:
                    AsignarImagenABoton(R.id.Boton7);
                    break;
                case 7:
                    AsignarImagenABoton(R.id.Boton8);
                    break;
                case 8:
                    AsignarImagenABoton(R.id.Boton9);
                    break;
            }
        }
    }

    int AsignarImagenABoton(int IdBotonAAsignar) //Esto funciona
    {
        Random GeneradorDeAzar;
        GeneradorDeAzar = new Random();

        int NumeroImagen;
        NumeroImagen = GeneradorDeAzar.nextInt(2);

        ImageButton BotonACambiar = (ImageButton) findViewById(IdBotonAAsignar);

        if (NumeroImagen == 0)
        {
            BotonACambiar.setImageResource(R.drawable.rojo);
        }
        else
        {
            BotonACambiar.setImageResource(R.drawable.verde);
        }
        return NumeroImagen;
    }

    public void Boton (View VistaBoton) //Recontra funciona
    {
        ImageButton BotonPresionado = (ImageButton)VistaBoton;
        String StrBotonPresionado = BotonPresionado.getTag().toString();
        int IntBotonPresionado = Integer.parseInt(StrBotonPresionado);
        switch (IntBotonPresionado)
        {
            case (0):
                InversionBotones(0, 1, 3, 4);
                ChequeoSiGane();
                break;
            case (1):
                InversionBotones(1, 0, 2, 4);
                ChequeoSiGane();
                break;
            case (2):
                InversionBotones(2, 1, 4, 5);
                ChequeoSiGane();
                break;
            case (3):
                InversionBotones(3, 0, 4, 6);
                ChequeoSiGane();
                break;
            case (4):
                InversionBotones(4, 1, 3, 5);
                ChequeoSiGane();
                break;
            case (5):
                InversionBotones(5, 2, 4, 8);
                ChequeoSiGane();
                break;
            case (6):
                InversionBotones(6, 3, 4, 7);
                ChequeoSiGane();
                break;
            case (7):
                InversionBotones(7, 4, 6, 8);
                ChequeoSiGane();
                break;
            case (8):
                InversionBotones(8, 4, 5, 7);
                ChequeoSiGane();
                break;
        }
    }

    public void InversionBotones(int BtnApretado, int BtnACambiarA, int BtnACambiarB, int BtnACambiarC) //Funca baby de manera muy piola
    {
        Drawable.ConstantState CodigoImagenRojo = ContextCompat.getDrawable(this, R.drawable.rojo).getConstantState();
        ImageButton[] ArrayBotonesAux = new ImageButton[4];
        ArrayBotonesAux[0] = ArrayBotones[BtnApretado];
        ArrayBotonesAux[1] = ArrayBotones[BtnACambiarA];
        ArrayBotonesAux[2] = ArrayBotones[BtnACambiarB];
        ArrayBotonesAux[3] = ArrayBotones[BtnACambiarC];
        for(int i=0; i<=3; i++)
        {
            Drawable.ConstantState CodigoImagenBotonApretado = ArrayBotonesAux[i].getDrawable().getConstantState();
            if (CodigoImagenBotonApretado == CodigoImagenRojo)
            {
                ArrayBotonesAux[i].setImageResource(R.drawable.verde);
                if (BtnApretado == 4)
                {
                    ArrayBotones[7].setImageResource(R.drawable.verde);
                }
            }
            else
            {
                ArrayBotonesAux[i].setImageResource(R.drawable.rojo);
                if (BtnApretado == 4)
                {
                    ArrayBotones[7].setImageResource(R.drawable.rojo);
                }
            }
        }
    }

    public void ChequeoSiGane() //Funciona tranka palanka
    {
        Drawable.ConstantState CodigoImagenRojo = ContextCompat.getDrawable(this, R.drawable.rojo).getConstantState();
        Drawable.ConstantState CodigoImagenVerde = ContextCompat.getDrawable(this, R.drawable.verde).getConstantState();
        int i = 0;
        switch (i)
        {
            case 0:
                int ContadorGanadorRojo = 0;
                for (int JUJU=0; JUJU <=8; JUJU++)
                {
                    Drawable.ConstantState CodigoBoton = ArrayBotones[JUJU].getDrawable().getConstantState();
                    if (CodigoBoton == CodigoImagenRojo)
                    {
                        ContadorGanadorRojo++;
                        if(ContadorGanadorRojo == 8)
                        {
                            Toast MensajeGanador = Toast.makeText(this, "¡Felicidades, ganaste!", Toast.LENGTH_SHORT);
                            MensajeGanador.show();
                            for (int GANASTEBABY = 0; GANASTEBABY <= 8; GANASTEBABY++)
                            {
                                ArrayBotones[GANASTEBABY].setEnabled(false);
                                ArrayBotones[GANASTEBABY].setImageResource(android.R.color.transparent);
                            }
                            break;
                        }
                    }
                    else
                    {
                        i++;
                        break;
                    }
                }
            case 1:
                int ContadorGanadorVerde = 0;
                for (int JUJU=0; JUJU <=8; JUJU++)
                {
                    Drawable.ConstantState CodigoBoton = ArrayBotones[JUJU].getDrawable().getConstantState();
                    if (CodigoBoton == CodigoImagenVerde)
                    {
                        ContadorGanadorVerde++;
                        if(ContadorGanadorVerde == 8)
                        {
                            Toast MensajeGanador = Toast.makeText(this, "¡Felicidades, ganaste!", Toast.LENGTH_SHORT);
                            MensajeGanador.show();
                            for (int GANASTEBABY = 0; GANASTEBABY <= 8; GANASTEBABY++)
                            {
                                ArrayBotones[GANASTEBABY].setEnabled(false);
                                ArrayBotones[GANASTEBABY].setImageResource(android.R.color.transparent);
                            }
                            break;
                        }
                    }
                    else
                    {
                        i++;
                        break;
                    }
                }
        }
    }
}
