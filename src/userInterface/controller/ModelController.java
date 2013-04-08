package userInterface.controller;

import main.*;
import userInterface.view.IModel;

/**
 * 	<ul>
 * 		<p>Creates a handle on the model of the data.</p>
 * 		@author Daniel
 * 	</ul>
 * 
 *
 */
public class ModelController implements IModel {
	Game game = Game.getInstance();
	private boolean validSelectionMade = false;
	
	/**
	 * 	<!--Accessor Method-->
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul>
	 * 		<li><b>IModel</b></li>
	 * 	</ul>
	 * 	<ul><div ID="method"><p>public void gameInstance(int mode)</p></div></ul>
	 * 	<ul>
	 * 		<p> 
	 * 			This will create a handle on the model data. Specifically it will get the
	 * 			game mode; single player or multi player. Also it will speak the HumanPlayer 
	 * 			class by constantly sending locations to be checked for validity. 
	 * 		</p>
	 * 		<p>
	 *  		PreCondition: A mode must be passed in. 
	 *  		<br>PostCondition: A mode will chosen and the game will begin.<br>
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		@param mode The mode of the game, determined by which button is clicked.
	 * 	</ul>
	 */
	public void gameInstance(int mode) {
		Thread gameLauncher = new Thread(new GameLauncher(mode));
		gameLauncher.start();
	}

	/**
	 * 	<!--Accessor Method-->
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul>
	 * 		<li><b>IModel</b></li>
	 * 	</ul>
	 * 	<ul><div ID="method"><p>public void scoreBoardInstance</p></div></ul>
	 * 	<ul>
	 * 		<p> 
	 * 			This will create a handle on the model data. Specifically it will gather the
	 * 			data stored containing the wins and losses for the user. If no file exists,
	 * 			a file will be created that contains zero wins and zero losses. 
	 * 		</p>
	 * 	</ul>
	 */
	public void scoreBoardInstance() {
	}
	
	public void setStartLocation(Player currentPlayer, Location aLoc){
		validSelectionMade = false;
		currentPlayer.setStart(aLoc);
		
		if(currentPlayer.validStartSelected() == false){
			return;
		} else {
			validSelectionMade = true;
		}
	}
	
	public void setEndLocation(Player currentPlayer, Location aLoc){
		validSelectionMade = false;
		if(aLoc.isSameLocation(currentPlayer.getStart())) {
			currentPlayer.resetLocations();
			return;
		}
		currentPlayer.setEnd(aLoc);
		
		if(currentPlayer.validEndSelected() == false){
			currentPlayer.resetLocations();
			return;
		} else {
			validSelectionMade = true;
		}
		
	}
	
	public void makeMove(Player currentPlayer){
		game.currentPlayer().makeCurrentMove();
	}
	
	public boolean validSelectionMade(){
		return validSelectionMade;
	}

}