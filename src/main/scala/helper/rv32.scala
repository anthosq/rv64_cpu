package npc.helper.rv32

import chisel3._
import chisel3.util._

object Inst {
  // RISC-V 32E
  // Non-Privileged Instruction Formats
  def LUI   = BitPat("b?????????????????????????0110111")
  def AUIPC = BitPat("b?????????????????????????0010111")
  def JAL   = BitPat("b?????????????????????????1101111")
  def JALR  = BitPat("b?????????????????000?????1100111")
  
}
