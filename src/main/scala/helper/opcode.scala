package npc.helper.opcode

import chisel3._
import chisel3.util._

object opEXU {
  def EX_NOP  = 0.U(7.W)
  def EX_PS1  = 1.U(7.W)
  def EX_ADD  = 2.U(7.W)
  def EX_SLT  = 3.U(7.W)
  def EX_SLTU = 4.U(7.W)
  def EX_XOR  = 5.U(7.W)
  def EX_OR   = 6.U(7.W)
  def EX_AND  = 7.U(7.W)
  def EX_SLL  = 8.U(7.W)
  def EX_SRL  = 9.U(7.W)
  def EX_SRA  = 10.U(7.W)
  def EX_SUB  = 11.U(7.W)
}
