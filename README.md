# DAM - RPOGRAMACIÓN DE SERVICIOS Y PROCESOS - TAREA 05 - Técnicas de Programación Segura:

- - -
<img src="./readme_imagenes/icono_40.png" align="right" width="90"/>

En esta aplicación se trabajarán los siguientes recursos:
* Proteger las aplicaciones y los datos definiendo y aplicando criterios de seguridad en el acceso, almacenamiento y transmisión de la información.

Curso académico: 2017-2018

- - -
## Índice:

[TOC]

### Cómo usar la aplicación:
La aplicación se abre en el IDE [NetBeans] y se ejecuta en la consola del IDE. 
También puede ejecutarse abriendo una consola desde la ubicación:
* PSP_Tarea05_Seguridad\PSP_Tarea05\dist\ y ejecutando:
	* java -jar PSP_Tarea05.jar

Se pueden borrar los siguientes directorios con su contenido para realizar una **ejecución desde cero**:

- Datos_de_Logger
- Datos_del_Programa

- - -
#### Sistemas Operativos:
Para Windows y Linux.

- - -
### Desarrollo:
1. Se inicia el proyecto.
2. Ejercico 1. Validación de un Login utilizando patrones y guardando los datos de los usuarios validados en un archivo txt.
3. Añadiendo información a este documento.
4. Añadir una clase Logger que registre el log de la ejecución.
5. Clase **JUnit** para testear la clase seguridad.**ValidaLogin.java**
6. Crear el Javadoc con toda la documentación del programa.
7. **V1.0.0** - Aplicación terminada.
_ _ _
### Procesos de trabajo:
1. Se incia el proyecto. **Commit**
2. Ejercicio 1: **Commit**
Crear una aplicación en Java que pida unos datos y los valide utilizando la clase Pattern. Los datos se guardarán en un fichero de texto (datos.txt)
La aplicación funcionará siguiendo los siguientes pasos:
	1.	Primero se solicita el correo electrónico del usuario que va a utilizar la aplicación. Tendrá que ser validado con el siguiente formato usuario@servidor.dominio donde usuario puede tener 8 caracteres, que podrán ser letras, números, o el carácter '_'; el primer carácter tiene que ser una letra en minúscula. Servidor será una cadena de caracteres formada por letras y números; dominio será como máximo de 3 caracteres.
	2.	Solicitará una serie de datos que deberán cumplir unos determinados requisitos. 
		o	Nombre: cadena de caracteres que puede incluir el espacio y una longitud máxima de 15.
		o	Apellidos: cadena de caracteres que puede incluir el espacio y una longitud máxima de 15.
		o	Teléfono: 999/999/999
		o	Fecha de nacimiento: validar si la fecha es correcta según el formato dd/mm/yyyy
		o	Código postal: 99999
	3.	Los requisitos se deberán indicar a la hora de pedir los datos. En el caso de no cumplirse un patrón deberá mostrarse un mensaje y volver a pedirlo hasta que cumpla los requisitos indicados.
	El objetivo más importante de la aplicación es realizar la validación de los datos de entrada y el control de excepciones.

3. Ejercicio 1: (Continuación) **Commit**
Este commit no ha variado el código, tan solo es para definir un poco más de información sobre el proceso a este documento.
	- Definir un poco más la información de este documento README.
		- En el proyecto de la aplicación: Se ha creado la siguiente estructura:
		![img01]
        - Además en la carpeta PSP_Tarea05_Seguridad\\**readme_ficheros** se encuentra un archivo llamado: **validar_emails.txt**. Este archivo contiene toda la información de como se ha creado el patrón para calidar el email del usuario.
        - Y dentro del proyecto el programa crea el directorio: PSP_Tarea05_Seguridad\PSP_Tarea05\\**Datos_del_Programa** y el archivo **datos.txt** dónde se guardan los datos de los usuarios.

4. Ejercicio 2: **Commit**
Se añade una clase Logger a la aplicación para llevar un control de los eventos importantes que suceden (Ejem: registro del correo electrónico del usuario que utiliza la aplicación, los errores producidos...).
	* La clase se llama **AppLogger.java**
	* Los log se guardan en el directorio que crea el programa:
		* PSP_Tarea05\Datos_de_Logger\\**logger.log**

5. Se crea una clase de Test JUnit para realizar pruebas unitarias de la clase seguridad.**ValidaLogin.java**, realizando una ejecución controlada parametrizada para evaluar el funcionamiento de los dos métodos de la clase y comprobar que se obtiene el resultado esperado.
Las pruebas se realizan parametrizando con una cantidad amplia de valores la clase JUnit:
![img02]

6. Se crea el Javadoc con toda la documentación del programa. El Javaoc se encuentra en:
	* PSP_Tarea05_Seguridad\PSP_Tarea05\dist\javadoc\\**index.html**

7. Últimas comprobaciones: Lanzamiento de la V1.0.0. **Commit**

- - -
#### Fuentes de información:
![ico01]
https://icons8.com/

La propia unidad del temario: Unidad 5 de PSP – DAM:
- 20170620-00-DAM(02)\20180205-00-PDFsSegundaEvaluacion\20180205-04-PSP-PDFs\Apuntes\\**PSP-tema05.pdf**

https://amatellanes.wordpress.com/2013/05/29/java-validar-direccion-de-correo-electronico-en-java/
http://www.forosdelweb.com/f4/necesito-expresion-regular-para-validar-acentos-n-html5-1108258/
https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html#getLogger(java.lang.String)
https://javiergarciaescobedo.es/programacion-en-java/28-programacion-estructurada/353-registro-de-traza-de-ejecucion-con-la-clase-logger

Mis propios trabajos en DAM en Entornos de Desarrollo:
- 20160727-00-DAM(01)\20161001-03-ED-EntornosDesarrollo\20161222-00-ED03_Tarea-Debug_JUnit\Sanchez_Portillo_JFran_ED03_Tarea_E1\\**Sanchez_Portillo_JFran_ED03_Tarea_E1.pdf**

- - -
### Imágenes:
No hay datos.

- - -
### Requisitos
- [Java] 7 o superior (para ejecutar la Aplicación).

- - -
### Instalación:
Esta aplicación no requere instalación. Para más información ver en este documento "Cómo usar la aplicación".

- - -
### Entorno de desarrollo
- La aplicación ha sido desarrollada utilizando el IDE [NetBeans].

- - -
### Licencia
Esta aplicación se ofrece bajo licencia [Creative Commons Attribution 4.0].

- - -
### Fecha de creacción del proyecto:
viernes, 23 de marzo de 2018 19:35

- - -
### Fecha de la última actualización:
lunes, 26 de marzo de 2018 17:02

- - -

[ico01]: ./readme_imagenes/icono_40.png
[img01]: ./readme_imagenes/img01.jpg
[img02]: ./readme_imagenes/img02.jpg


[Java]: https://www.java.com/
[NetBeans]: https://netbeans.org/
[Creative Commons Attribution 4.0]: (https://choosealicense.com/licenses/cc-by-4.0/)


