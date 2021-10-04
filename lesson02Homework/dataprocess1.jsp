
<%
	int rows = Integer.parseInt(request.getParameter("rows"));
	int columns = Integer.parseInt(request.getParameter("columns"));
	
	out.write("Rows :" + rows + "; Colunms :" + columns);
	
	
	int values =(rows * columns);
	
	
	
	
%>

	
<table>
<tr>
	<%
	for(int i = 1 ; i <= values; i++) {
		
	%>
		
		<td>  <% 
		if((i%2)==0) out.write("<font color='green'>"+ i + "</font>" ); %> 
		<% if((i%2)!=0) out.write(""+i); %> 
		</td>
		
		<% 	if( (i%columns)==0 ) %> </tr><tr>
	<%
	}
	%>
</tr>
</table>
	
	

