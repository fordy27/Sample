/**
 * 
 */

    $(document).ready(function() {
        $('#add-user').click(function(event) {
        var confirmed = confirm("Are you sure you want to submit the form?");
        
        if (!confirmed) {
            event.preventDefault(); // Prevent form submission
        
        
        
        }
        
	   });
    });