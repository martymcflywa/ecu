# Classic ASP and PHP code snippets

## Simple required validation

### PHP

``` php
function CheckBlanks() {
	$user = array();
	$required = array();
	// loop over post
	foreach($_POST as $key => $value) {
		// ignore submit button
		if($key != "Submit") {
			if(strlen($value) > 0) {
				// if not empty, store key/value pair as 2d array
				$user[] = array($key => $value);
			} else {
				// if empty, store key in required array
				$required[] = $key;
			}
		}
	}
	// if there are empty fields, print error
	if(sizeof($required) > 0) {
		echo("Error/s:<br />");
		foreach($required as $value) {
			echo("* $value is required!<br />");
		}
	// else print input
	} else {
		echo("Success!<br />");
		foreach($user as $key => $value) {
			echo("$key: $value<br />");
		}
	}
}
```

### Classic ASP

``` asp
sub CheckBlanks() {
	dim user(4,2), required(4)
	dim i
	i = 0
	' loop over request.form
	for each item in request.form
		' ignore submit button
		if item <> "Submit" then
			if len(request.form(item)) > 0 then
				' if not empty, store key/value pair as 2d array
				user(i, 0) = item
				user(i, 1) = request.form(item)
			else
				' if empty, store key in required array
				required(i) = item
			end if
		end if
		' increment i
		i = i + 1
	next
	' if there are empty fields, print error
	if ubound(required) > 0 then
		response.write("Error/s:<br/>")
		for each(item in required)
			response.write("* " & item & " is required!<br />")
		next
	' else print input
	else
		response.write("Success!<br />")
		for each(item in user)
			response.write(user(item, 0) & ": " & user(item, 1) & "<br />")
		next
	end if
}
```

## Sessions

- Write code inside `Page_LoadComplete` event
- Checks to see if a session `MySession` exists
- If exists
	- Assign `MySession` value to `lblSessionState` control as its text value
	- Change `btnSessionState` text value to `"Close Session"`
- Else does not exist
	- Create session
	- Assign value `12345678`
- If `"Close Session"` button clicked
	- Page posts back to itself
	- Detects postback
	- Clears session using `Session.Abandon`

### CSharp

``` csharp
void Page_LoadComplete(Object sender, EventArgs e) {
	if(Session["MySession"] != null) {
		// update label/button text
		lblSessionState.text = Session["MySession"];
		btnSessionState.text = "Close Session";
		// hook up button up to eventhandler
		btnSessionState.Click += new EventHandler(this.btnSessionStateClick);
	} else {
		// set session
		Session["MySession"] = 12345678;
	}
}
// eventhandler for Close Session button
void btnSessionStateClick(Object sender, EventArgs e) {
	// only do this if text says "Close Session"
	if(btnSessionState.text == "Close Session") {
		// abandon session
		Session.Abandon;
		// post user back to same page
		Response.Redirect(Request.RawUrl);
	}
}
```

## Advanced validation

![question 10](http://snag.gy/9J5Pg.jpg)

### PHP

``` php
$game = array();
$gameErrors = array();
$competitors = array();
$competitorsErrors = array();

retrieveGame();
retrieveCompetitors();

if(sizeof($gameErrors) > 0 || sizeof($competitorErrors) > 0) {
	// display error view
} else {
	// display results view
}

// populate games array
function retrieveGame() {
	// year
	$year = 0;
	if(strlen($_POST["YearOfGames"]) > 0) {
		$year = $_POST["YearOfGames"];		
	} else {
		$gameErrors[] = "Year of games is required";
	}
	if($year >= 1896 && $year <= 2100) {
		$game[] = array("Year", $year);
	} else {
		$gameErrors[] = "Year of games must be valid, between 1896 and 2100";
	}

	// city
	if(strlen($_POST["CityOfGames"]) > 0) {
		$game[] = array("City", $_POST["CityOfGames"]);
	} else {
		$gameErrors[] = "City of games is required";
	}

	// commence date
	if(strlen($_POST["CommenceDate"]) > 0) {
		$game[] = array("CommenceDate", $_POST["CommenceDate"]);
	} else {
		$gameErrors[] = "Commence date of games is required";
	}

	// end date
	if(strlen($_POST["EndDate"]) > 0) {
		$game[] = array("EndDate", $_POST["EndDate"]);
	} else {
		$gameErrors[] = "End date of games is required";
	}
}

// populates competitors array
function retrieveCompetitors() {

	// limit iteration to number of competitor rows
	for($i = 0; $i < count($_POST) - 4; $i++) {

		$j = $i + 1;

		if($_POST["Competitor" . $j] != "" &&
				$_POST["Country" . $j] != "" &&
				$_POST["Event" . $j] != "" &&
				$_POST["Medal" . $j] != "" &&
				$_POST["WR" . $j] != ""
		) {
			$competitors[] = array(
				"Competitor" => $_POST["Competitor" . $j],
				"Country" => $_POST["Country" . $j],
				"Event" => $_POST["Event" . $j],
				"Medal" => $_POST["Medal" . $j],
				"WR" => $_POST["WR" . $j]
			);
		} else {
			$competitorErrors[] = "Missing input at row " . $j
		}
	}
}
```

### Classic ASP

``` asp
dim game(4), gameErrors(4)
dim competitors(50, 4), competitorErrors(50)

call retrieveGame()
call retrieveCompetitors()

if ubound(gameErrors) > 0 or ubound(competitorErrors) > 0 then
	' display error view
else
	' display results view
end if

sub retrieveGame() {
	dim year, errors
	year = 0
	errors = 0

	if request.form("YearOfGames") <> "" then
		year = request.form("YearOfGames")
	else
		errors = errors + 1
		gameErrors(errors - 1) = "Year of games is required"
	end if

	if year >= 1896 or year <= 2100 then
		game(0) = request.form("YearOfGames")
	else
		errors = errors + 1
		gameErrors(errors - 1) = "Year of games must be valid, between 1896 and 2100"
	end if

	if request.form("CityOfGames") <> "" then
		game(1) = request.form("CityOfGames")
	else
		errors = errors + 1
		gameErrors(errors - 1) = "City of games is required"
	end if

	if request.form("CommenceDate") <> "" then
		game(2) = request.form("CommenceDate")
	else
		errors = errors + 1
		gameErrors(errors - 1) = "Commence date of games is required"
	end if

	if request.form("EndDate")) <> "" then
		game(3) = request.form("EndDate")
	else
		errors = errors + 1
		gameErrors(errors - 1) = "End date of games is required"
	end if
}

sub retrieveCompetitors() {
	dim errors
	errors = 0

	for i = 0 to request.form.count
		dim j
		j = i + 1

		if request.form("Competitor" & j) <> "" &&
				request.form("Country" & j) <> "" &&
				request.form("Event" & j) <> "" &&
				request.form("Medal" & j) <> "" &&
				request.form("WR" & j) <> "" then
			competitors(i, 0) = request.form("Competitor" & j)
			competitors(i, 1) = request.form("Country" & j)
			competitors(i, 2) = request.form("Event" & j)
			competitors(i, 3) = request.form("Medal" & j)
			competitors(i, 4) = request.form("WR" & j)
		else
			errors = errors + 1
			competitorErrors(errors - 1) = "Missing input at row " & j
		end if
	next
}
```
