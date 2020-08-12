package io.hsar.wh40k.combatsimulator.logic.actionoptions

import io.hsar.wh40k.combatsimulator.dice.Result.FAILURE
import io.hsar.wh40k.combatsimulator.dice.Result.SUCCESS
import io.hsar.wh40k.combatsimulator.model.UnitInstance
import io.hsar.wh40k.combatsimulator.model.World

class SingleRangedAttack(override val damage: String, val range: Int): RangedAttack() {
    override val actionCost = ActionCost.HALF_ACTION
    override val bonusToHit = 10

    override fun isLegal(world: World, user: UnitInstance, target: UnitInstance): Boolean {
        // check target is in melee range of user
        return world.distanceApart(user, target) <= range
    }

    override fun expectedValue(world: World, user: UnitInstance, target: UnitInstance): Float {
        return getHitChance(user) * getAverageDamage(target)
    }

    override fun apply(world: World, user: UnitInstance, target: UnitInstance): Unit {
        rollToHit(user).let { rollResult ->
            when (rollResult.result) {
                SUCCESS -> applyHits(target, 1)
                FAILURE -> return
            }
        }
    }
}