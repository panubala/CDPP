  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 0
          # Emitting 0
          movl $0, %edi
          # Emitting i0
          subl $4, %esp
        movl %edi, -4(%ebp)
        # Emitting i1 = 1
          # Emitting 1
          movl $1, %esi
          # Emitting i1
          subl $4, %esp
        movl %esi, -8(%ebp)
        # Emitting i2 = 2
          # Emitting 2
          movl $2, %edi
          # Emitting i2
          subl $4, %esp
        movl %edi, -12(%ebp)
        # Emitting i3 = 3
          # Emitting 3
          movl $3, %esi
          # Emitting i3
          subl $4, %esp
        movl %esi, -16(%ebp)
        # Emitting i4 = 4
          # Emitting 4
          movl $4, %edi
          # Emitting i4
          subl $4, %esp
        movl %edi, -20(%ebp)
        # Emitting i5 = 5
          # Emitting 5
          movl $5, %esi
          # Emitting i5
          subl $4, %esp
        movl %esi, -24(%ebp)
        # Emitting i6 = 6
          # Emitting 6
          movl $6, %edi
          # Emitting i6
          subl $4, %esp
        movl %edi, -28(%ebp)
        # Emitting i7 = 7
          # Emitting 7
          movl $7, %esi
          # Emitting i7
          subl $4, %esp
        movl %esi, -32(%ebp)
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
