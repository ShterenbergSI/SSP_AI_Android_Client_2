<? 
/* �������� �������� ����������, ���������� ������� POST*/
$name = $_POST['name'];
$dol = $_POST['dol'];
$tel = $_POST['tel'];


/* ������� ����������  � ��������� ����� ������ ������� MySQL, �������� � �������*/ 
mysql_connect($hostname,$username,$password) OR DIE("No connection"); 
/* ������� ���� ������ � ����� �������� ������. ���� ���������� ������ - ������� �� */ 
mysql_select_db($dbName) or die(mysql_error());  

/* ��������� � ������� ���������� ��������*/
$query = "INSERT INTO DATA  VALUES('$name',  '$dol', '$tel' )"; 
/* ��������� ������. ���� ���������� ������ - ������� ��. */ 
mysql_query($query) or die(mysql_error()); 
echo 'OK';
/* ������� ���������� */ 
mysql_close(); 
?>

