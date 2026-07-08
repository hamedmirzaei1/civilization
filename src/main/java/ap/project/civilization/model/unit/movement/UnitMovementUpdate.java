package ap.project.civilization.model.unit.movement;

import ap.project.civilization.model.unit.core.Unit;
import ap.project.civilization.model.unit.core.UnitManager;

public class UnitMovementUpdate {
    public static void update(Unit unit, UnitManager unitManager) {
        MovementComponent movement = unit.getMovement();
        if(!movement.isMoving()) return;
        if(movement.arrived()) {
            movement.setX(movement.getTargetX());
            movement.setY(movement.getTargetY());

            if(movement.getTargetHex() != null && !movement.getTargetHex().equals(unit.getCurrentHex())) {
                unitManager.changeUnitLocation(unit, unit.getCurrentHex(), movement.getTargetHex());
                unit.setCurrentHex(movement.getTargetHex());
                movement.setTargetHex(null);
            }

            movement.setDx(0);
            movement.setDy(0);
            movement.setMoving(false);

            unit.arrive();
            return;
        }

        movement.setX(movement.getX() + movement.getDx());
        movement.setY(movement.getY() + movement.getDy());
    }
}
