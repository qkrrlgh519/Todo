function moveType(id){
	var oReq = new XMLHttpRequest();
	
	var thisElement = event.currentTarget; //todo-button
	var thisParent = thisElement.parentElement;//todo-content
	var nextParent = thisParent.parentElement.previousElementSibling;
	var type = thisParent.parentElement.firstElementChild.innerText;//todo-type
	
	oReq.addEventListener("load", function(){
		if(this.responseText === "SUCCESS"){
			if(type === "DOING"){
				thisElement.remove();
			}
			nextParent.appendChild(thisParent);
		}
	});
	
	oReq.open("POST", "/Todo/todoType");
	oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	oReq.send("id="+id+"&type="+type);
}