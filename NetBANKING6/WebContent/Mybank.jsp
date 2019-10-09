<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
  <head>
    <title>Online Bank Simulator</title>
  </head>
  <body>
  <form method="POST" action="Mybank">
    <hr color="#808000">
      <center>
        <h1>Banking Simulation</h1>
      </center>
         
         
      <form method="POST" action="Mybank">
        <center>Amount: <input type="text" name="Amount" size="20"></center>
 
         <table width="35%" align="center">
           <tr>
             <td width="33%" align="center">
                <input type="text" name="act" value="Balance">
             <td width="33%" align="center">
                <input type="text" name="act" value="Deposit">
             </td>
             <td width="33%" align="center">
                <input type="text" name="act" value="Withdraw">
             </td>
             <td width="33%" align="center">
             </td>
           </tr>
               <tr>
		<td>
			Username:
		</td>
		<td>
			<input type="text" placeholder="Username" name="Username">
		</td>
	</tr>
	<tr>
		<td>
			Password:
		</td>
		<td>
			<input type="Password" placeholder="Password" name="Password">
		</td>
	</tr>
	 <tr>
	 	<td>
	 		<input type="Submit" value="sign in" name="">
	 	</td>
	 </tr>
         </table>
         <br>
     </form>
   <hr color="#80800">
   </form>
  </body>
</html>