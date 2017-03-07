  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
.LC2:
    .string "%d"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 0
          # Emitting i0
          subl $4, %esp
          # Emitting 0
          movl $0, %esi
        movl %esi, -4(%ebp)
        # Emitting i1 = 1
          # Emitting i1
          subl $4, %esp
          # Emitting 1
          movl $1, %esi
        movl %esi, -8(%ebp)
        # Emitting i2 = 2
          # Emitting i2
          subl $4, %esp
          # Emitting 2
          movl $2, %esi
        movl %esi, -12(%ebp)
        # Emitting i3 = 3
          # Emitting i3
          subl $4, %esp
          # Emitting 3
          movl $3, %esi
        movl %esi, -16(%ebp)
        # Emitting i4 = 4
          # Emitting i4
          subl $4, %esp
          # Emitting 4
          movl $4, %esi
        movl %esi, -20(%ebp)
        # Emitting i5 = 5
          # Emitting i5
          subl $4, %esp
          # Emitting 5
          movl $5, %esi
        movl %esi, -24(%ebp)
        # Emitting i6 = 6
          # Emitting i6
          subl $4, %esp
          # Emitting 6
          movl $6, %esi
        movl %esi, -28(%ebp)
        # Emitting i7 = 7
          # Emitting i7
          subl $4, %esp
          # Emitting 7
          movl $7, %esi
        movl %esi, -32(%ebp)
        # Emitting r1 = (i0 + (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))))
          # Emitting r1
          subl $4, %esp
          # Emitting (i0 + (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))))
            # Emitting i0
            movl -4(%ebp), %esi
            # Emitting (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7))))))
              # Emitting i1
              movl -8(%ebp), %edx
              # Emitting (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))
                # Emitting i2
                movl -12(%ebp), %ecx
                # Emitting (i3 + (i4 + (i5 + (i6 + i7))))
                  # Emitting i3
                  movl -16(%ebp), %ebx
                  # Emitting (i4 + (i5 + (i6 + i7)))
                    # Emitting i4
                    movl -20(%ebp), %eax
                    # Emitting (i5 + (i6 + i7))
                      # Emitting i5
