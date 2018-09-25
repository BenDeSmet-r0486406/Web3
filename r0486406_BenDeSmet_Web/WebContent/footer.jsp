

<footer>
	&copy; Webontwikkeling 3, UC Leuven-Limburg
	<form method="post" action="Controller?action=switchColor">


		<input type="submit" id="switchColor" value="Color switch"> <input
			type="hidden" name="kleur" value="${param.kleur }"> <input
			type="hidden" name="Hallo" value="${param.Hallo }">




		<c:choose>
			<c:when test="${param.Hallo eq 'update product' }">

				<input type="hidden" name="id" value="${param.id }">

			</c:when>

		</c:choose>


	<%-- 	<c:choose>
			<c:when test="${param.Halo eq '' }">


				<input type="hidden" name="titel" value="${param.Hallo }">

			</c:when>

			<c:when test="${ }">


				<input type="hidden" name="titel" value="${param.Hallo }">

			</c:when>
		</c:choose> --%>





	</form>
</footer>