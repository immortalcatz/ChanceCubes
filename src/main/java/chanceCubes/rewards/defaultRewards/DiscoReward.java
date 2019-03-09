package chanceCubes.rewards.defaultRewards;

import chanceCubes.CCubesCore;
import chanceCubes.blocks.CCubesBlocks;
import chanceCubes.util.RewardsUtil;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DiscoReward extends BaseCustomReward
{
	public DiscoReward()
	{
		super(CCubesCore.MODID + ":Disco", 40);
	}

	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player)
	{
		for(int xx = -4; xx < 5; xx++)
			for(int zz = -4; zz < 5; zz++)
				RewardsUtil.placeBlock(Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(RewardsUtil.rand.nextInt(16))), world, pos.add(xx, -1, zz));

		for(int i = 0; i < 10; i++)
		{
			EntitySheep sheep = new EntitySheep(world);
			sheep.setCustomNameTag("jeb_");
			sheep.setLocationAndAngles(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0);
			world.spawnEntity(sheep);
		}

		RewardsUtil.placeBlock(CCubesBlocks.CHANCE_ICOSAHEDRON.getDefaultState(), world, pos.add(0, 3, 0));

		RewardsUtil.sendMessageToNearPlayers(world, pos, 32, "Disco Party!!!!");
	}
}