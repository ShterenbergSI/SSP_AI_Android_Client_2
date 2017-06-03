<? 
/* получаем значения переменных, переданных методом POST*/
$name = $_POST['name'];
$dol = $_POST['dol'];
$tel = $_POST['tel'];


/* создать соединение  с заданными ранее именем сервера MySQL, лоргином и паролем*/ 
mysql_connect($hostname,$username,$password) OR DIE("No connection"); 
/* выбрать базу данных с ранее заданным именем. Если произойдет ошибка - вывести ее */ 
mysql_select_db($dbName) or die(mysql_error());  

/* вставляем в таблицу переданные значения*/
$query = "INSERT INTO DATA  VALUES('$name',  '$dol', '$tel' )"; 
/* выполнить запрос. Если произойдет ошибка - вывести ее. */ 
mysql_query($query) or die(mysql_error()); 
echo 'OK';
/* закрыть соединение */ 
mysql_close(); 
?>

