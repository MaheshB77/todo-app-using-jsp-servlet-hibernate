
<!-- Modal -->
<div class="modal fade" id="addTodo" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add TODO</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<form action="TODOController" method="post">
					<div class="form-group">
						<label for="todoName">TODO Description</label> <input type="text"
							class="form-control" id="todoName" name="todoName" required>
					</div>
					<div class="form-group">
						<label for="todoTargetDate">Set target date for this todo
						</label> <input type="date" class="form-control" id="todoTargetDate"
							name="todoTargetDate" required>
					</div>

					<div class="container text-center">

						<button type="submit" class="btn btn-success">Add TODO</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>


				</form>

			</div>

		</div>
	</div>
</div>