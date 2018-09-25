

<footer>
	&copy; Webontwikkeling 3, UC Leuven-Limburg
	<form method="post" action="Controller?action=switchColor">
		<input type="hidden" name="currentPage" value="${param.currentPage }">
		<input type="hidden" name="kleur" value="${param.kleur }">
		
		
		<input type="submit" id="SwitchColor" value="Color switch">
	</form>
</footer>